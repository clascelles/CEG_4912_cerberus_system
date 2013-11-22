package com.cerberus.module.overview.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.model.system.bean.EventRecord;
import com.cerberus.model.usage.bean.SystemTip;
import com.cerberus.model.usage.bean.Tip;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.overview.backingobjects.EventBackingObject;
import com.cerberus.module.overview.backingobjects.EventBackingObjectFactory;
import com.cerberus.module.overview.backingobjects.TipBackingObject;
import com.cerberus.module.overview.backingobjects.TipBackingObjectFactory;
import com.cerberus.module.overview.backingobjects.TopBarBackingObject;
import com.cerberus.module.overview.constants.OverviewConstants;
import com.cerberus.module.schedules.backingobjects.ScheduledEventBackingObject;
import com.cerberus.module.schedules.backingobjects.ScheduledEventBackingObjectFactory;
import com.cerberus.module.schedules.workflows.ScheduleWorkflow;
import com.cerberus.module.system.workflows.EventWorkflow;
import com.cerberus.module.usage.backingobjects.UsageBackingObject;
import com.cerberus.module.usage.constants.UsageConstants;
import com.cerberus.module.usage.controllers.UsageController;
import com.cerberus.module.usage.workflows.UsageWorkflow;

@Controller
@RequestMapping(value="/home/index")
public class OverviewController extends CerberusController {

	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(Model model, HttpServletRequest request)
			//This is how you can retrieve the object from the redirectAttrs.addFlashAttribute() method. It behaves exactly
			//like a model attribute at this point.
			//@ModelAttribute("user") User user
	{
		User user = getUser(request);
		if(user == null){
			return CerberusConstants.REDIRECT;
		}
		initTopBar(model, user);

		TopBarBackingObject topBarBackingObject = new TopBarBackingObject();
		topBarBackingObject.setName(user.getInformation().getFirstName() + " " + user.getInformation().getLastName());

		model.addAttribute(OverviewConstants.TOP_BAR_BACKING_OBJECT, topBarBackingObject);

		EventWorkflow eventWorkflow = CerberusApplicationContext.getWorkflows().getEventWorkflow();
		Integer systemId = user.getLogin().getSystem().getId();

		List<EventRecord> events = eventWorkflow.getMostRecentEvents(systemId, 10);
		List<EventBackingObject> eventsBO = EventBackingObjectFactory.INSTANCE.getBackingObjects(events);
		
		UsageWorkflow usageWorkflow = CerberusApplicationContext.getWorkflows().getUsageWorkflow();
		List<Tip> tips = usageWorkflow.getLatest10Tips(systemId);
		List<SystemTip> systemTips = usageWorkflow.getLatest10SystemTips(systemId);
		
		List<TipBackingObject> tipsBO = TipBackingObjectFactory.INSTANCE.getBackingObjects(tips, systemTips);

		//CONSUMPTION GRAPH
		UsageBackingObject usageOptions = new UsageBackingObject();
		double[] currentList = usageWorkflow.getCurrentByHourForDay(user, new Date());
		
		usageOptions.setGraphForDay();
		usageOptions.setMaximumYAxisValue(UsageController.maxValue(currentList));
		String currentListString = UsageController.arrayToJavascript(currentList);
		
		model.addAttribute(UsageConstants.USAGE_OPTIONS, usageOptions);
		model.addAttribute(UsageConstants.CURRENT_HOUR_LIST, currentListString);
		
		model.addAttribute(OverviewConstants.EVENTS, eventsBO);
		model.addAttribute(OverviewConstants.TIPS, tipsBO);

		ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
		List<ScheduledEvent> schedules = scheduleWorkflow.getTodaysScheduledEvents(user);
		List<ScheduledEventBackingObject> scheduledEventBackingObjects = ScheduledEventBackingObjectFactory.INSTANCE.getBackingObjects(schedules);
		
		model.addAttribute(CerberusConstants.SCHEDULED_EVENTS, scheduledEventBackingObjects);

		return "home/index";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model)	{
		return null;

	}

}
