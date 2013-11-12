package com.cerberus.frameworks.quartz;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cerberus.daemon.executor.ServiceBootstrap;
import com.cerberus.daemon.scheduling.CerberusScheduler;
import com.cerberus.frameworks.netty.CommunicationBootstrap;
import com.cerberus.frameworks.spring.ServerContext;

public class StartDaemonServerJob extends QuartzJobBean {

	private static String SERVER_ROOT;
	private final static String LOG4J_XML = "WEB-INF\\classes\\log4j.xml";
	private final static Logger LOGGER = Logger.getLogger(StartDaemonServerJob.class);

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

			//Get the Server ROOT directory.
			SERVER_ROOT = ServerContext.getServerRootUrl();

			DOMConfigurator.configure(SERVER_ROOT + LOG4J_XML);

			LOGGER.info("Bootstrapping the Cerberus server.");
			// Start all bootstrap threads here

			// Executor Services Bootstrap
			ServiceBootstrap service = new ServiceBootstrap();
			service.start();

			// Netty Communication Bootstrap
			CommunicationBootstrap communication = new CommunicationBootstrap();
			communication.start();

			//Scheduling Bootstrap
			// TODO: Change XmlBeanFactory to use ApplicationContext instead (or JobExecutionContext?)
			ClassPathResource res = new ClassPathResource("dynamic-jobs.xml");
	        XmlBeanFactory factory = new XmlBeanFactory(res);

	        //get the quartzFactory bean
	        Scheduler scheduler = (Scheduler) factory.getBean("scheduler");

	        CerberusScheduler cerberusScheduler = new CerberusScheduler();
	        cerberusScheduler.init(scheduler);
	        cerberusScheduler.start();

	}
}