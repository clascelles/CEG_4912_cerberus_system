package com.cerberus.frameworks.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.cerberus.module.generic.workflows.Workflows;

public class CerberusApplicationContext implements ApplicationContextAware{
	
	private static ApplicationContext ctx = null;
	private static Workflows workflows = null;
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		CerberusApplicationContext.ctx = ctx;
		workflows = ctx.getBean("workflows", Workflows.class);
	}

	public static Workflows getWorkflows() {
		return workflows;
	}
	
	


}