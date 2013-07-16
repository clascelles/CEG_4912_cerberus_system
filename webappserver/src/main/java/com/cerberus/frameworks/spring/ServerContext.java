package com.cerberus.frameworks.spring;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class ServerContext implements ServletContextAware{
   
	private static String serverRootUrl;
    
	public static String getServerRootUrl(){ 
		return serverRootUrl; 
	}
    
	public void setServletContext(ServletContext servletContext){
        ServerContext.serverRootUrl = servletContext.getRealPath("/");
    }
}
