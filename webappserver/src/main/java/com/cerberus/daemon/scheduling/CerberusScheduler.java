package com.cerberus.daemon.scheduling;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import com.cerberus.frameworks.quartz.ScheduledEventTask;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.module.schedules.workflows.ScheduleWorkflow;

public class CerberusScheduler extends Thread {
	
	static Scheduler scheduler;
	static XmlBeanFactory factory;
	static Integer maxIds = (int) Math.pow(10, 12);
	static Integer cronId;
	static List<RecurringEvent> recurringEvents;
	
	public static class RecurringEvent {
		ScheduledEvent event;
		MethodInvokingJobDetailFactoryBean job;
		public RecurringEvent(ScheduledEvent event,
				MethodInvokingJobDetailFactoryBean job) {
			super();
			this.event = event;
			this.job = job;
		}
		public ScheduledEvent getEvent() {
			return event;
		}
		public void setEvent(ScheduledEvent event) {
			this.event = event;
		}
		public MethodInvokingJobDetailFactoryBean getJob() {
			return job;
		}
		public void setJob(MethodInvokingJobDetailFactoryBean job) {
			this.job = job;
		}
	}
	
	public void init(Scheduler quartzScheduler, XmlBeanFactory factory) {
		this.scheduler = quartzScheduler;
		this.factory = factory;
		cronId = 0;
		recurringEvents = new ArrayList<RecurringEvent>();
		
		try {      
	        scheduler.start();
		} catch (Exception e) {                      
			e.printStackTrace();
		}
	}	
	
	@Override
	public void run() {
		
		Integer millisInSec = 1000;
		Integer secsInMin = 60;
		Integer min = secsInMin * millisInSec;
		Integer day = 24*60*secsInMin * millisInSec;
		
		// delay the start of this process until the next :59
		// so that we can be processing scheduled events from :00 - :59
		try {
			Date startTime = new Date();
			Integer secondDelay = startTime.getSeconds();			
			secondDelay = (secondDelay > 0) ? secondDelay-1 : 59;
			sleep(secondDelay*millisInSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {				
				// grab all the scheduled events
				List<ScheduledEvent> events = getEvents();
				
				// filter by only applicable for next minute
				for(ScheduledEvent event : events) {
					
					Date now = new Date();
					Date oneMin = new Date(now.getTime() + min);
					Date yesterday = new Date(now.getTime() - day);
					
					if(event.getTime().after(now) && event.getTime().before(oneMin)) {
						// schedule a cron job
						schedule(event);					
					} else if(event.getTime().before(yesterday) 
							&& event.getRecurrence().getId() == ScheduleRecurrence.ONCE_ID) {
						ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
						scheduleWorkflow.removeScheduledEvent(event);
					}
				}
				
				// wait a minute and run again
				sleep(min);
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private static List<ScheduledEvent> getEvents() {
		ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
		return scheduleWorkflow.getScheduledEvents();
	}
	
	public static void schedule(ScheduledEvent event) {
		try {
		    //get the task bean
		    ScheduledEventTask scheduleTask = (ScheduledEventTask) factory.getBean("scheduledEventTask");
		    scheduleTask.init(event);		    
		    
		    // create JOB
		    MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		    jobDetail.setTargetObject(scheduleTask);
		    jobDetail.setTargetMethod("execute");
		    jobDetail.setName("Job for Event: " + event.getId());
		    jobDetail.setConcurrent(false);
		    jobDetail.afterPropertiesSet();

		    /* SimpleTriggerBean trigger = new SimpleTriggerBean();
		    trigger.setBeanName("MyTrigger");
		    trigger.setJobDetail((JobDetail) jobDetail.getObject());
		    trigger.setRepeatInterval(5000);
		    trigger.afterPropertiesSet();
		    */

		    // create CRON Trigger
		    Integer id = getCronId();
		    String cronTriggerId = String.format("%012d", id);
		    
		    CronTriggerBean cronTrigger = new CronTriggerBean();
		    cronTrigger.setBeanName("CRON" + cronTriggerId);

		    // set the execution expression
		    cronTrigger.setCronExpression(getCronExpression(event));
		    cronTrigger.afterPropertiesSet();
		    
		    if(event.getRecurrence().getId() != ScheduleRecurrence.ONCE_ID) {
		    	recurringEvents.add(new RecurringEvent(event, jobDetail));
		    }

		    //scheduler.scheduleJob(jobDetail, cronTrigger);

		    scheduler.scheduleJob((JobDetail) jobDetail.getObject(), cronTrigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void unschedule(ScheduledEvent event) {		
		RecurringEvent recurring = getRecurringEvent(event);		
		if(recurring != null) {
		    try {
		    	scheduler.deleteJob(recurring.getJob().getObject().getName(), 
		    			recurring.getJob().getObject().getGroup());
		    	recurringEvents.remove(recurring);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static RecurringEvent getRecurringEvent(ScheduledEvent event) {
		for(RecurringEvent recurring : recurringEvents) {
			if(recurring.getEvent().getId().equals(event.getId())) {
				return recurring;
			}
		}
		return null;
	}
	
	private static String getCronExpression(ScheduledEvent event) {
		String wild = "*";
		String unspecified = "?";
		String ofWeek = "#";
		
		String year = String.valueOf(event.getTime().getYear() + 1900);
		String month = String.valueOf(event.getTime().getMonth() + 1);
		String date = String.valueOf(event.getTime().getDate());
		
		String dayOfWeek = unspecified;
		
		String hour = String.valueOf(event.getTime().getHours());
		String min = String.valueOf(event.getTime().getMinutes());
		String sec = String.valueOf(event.getTime().getSeconds());
		
		if(event.getRecurrence().getId() == ScheduleRecurrence.YEARLY_ID) {
			year = wild;
		}
		
		if(event.getRecurrence().getId() == ScheduleRecurrence.MONTHLY_ID) {
			year = wild;
			month = wild;
		}
		
		if(event.getRecurrence().getId() == ScheduleRecurrence.BI_WEEKLY_ID) {
			year = wild;
			month = wild;
			date = unspecified;
			dayOfWeek = getDayOfWeek(event.getTime().getDay() + 1)  + ofWeek + "1,3";
		}
		
		if(event.getRecurrence().getId() == ScheduleRecurrence.WEEKLY_ID) {
			year = wild;
			month = wild;
			date = unspecified;
			dayOfWeek = getDayOfWeek(event.getTime().getDay() + 1);
		}
		
		if(event.getRecurrence().getId() == ScheduleRecurrence.DAILY_ID) {
			year = wild;
			month = wild;
			date = wild;
		}
		
		if(event.getRecurrence().getId() == ScheduleRecurrence.HOURLY_ID) {
			year = wild;
			month = wild;
			date = wild;
			hour = wild;
		}
		
		return sec + " "
				+ min + " "
				+ hour + " "
				+ date + " "
				+ month + " "
				+ dayOfWeek + " " 
				+ year;
		//return "/5 * * * * ?";
	}
	
	private static String getDayOfWeek(Integer dayOfWeek) {
		switch(dayOfWeek) {
		case 1: return "MON";
		case 2: return "TUE";
		case 3: return "WED";
		case 4: return "THU";
		case 5: return "FRI";
		case 6: return "SAT";
		case 7: return "SUN";
		default: return "FAIL";
		}
	}
	
	private static Integer getCronId() {
		Integer id = cronId;
		cronId = cronId+1;
		if(cronId == maxIds) {
			cronId = 0;
		}
		return id;
	}
}
