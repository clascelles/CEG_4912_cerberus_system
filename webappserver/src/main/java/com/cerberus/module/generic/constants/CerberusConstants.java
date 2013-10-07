package com.cerberus.module.generic.constants;

public class CerberusConstants {

	//Model constants
	public static final String TOP_BAR_BACKING_OBJECT = "topBarBackingObject";
	
	//Navigation constants	
	public static final String SEPARATOR = "/";
	public static final String REDIRECT = "redirect:/";
	public static final String INDEX = "index";
	public static final String VIEW = "view";
		
	public static final String ACCOUNT_MODULE = "account";	
	public static final String ACCOUNT_VIEW = ACCOUNT_MODULE + SEPARATOR + INDEX;
	public static final String ACCOUNT_MAPPING = SEPARATOR + ACCOUNT_VIEW;
	
	public static final String OUTLETS_MODULE = "outlets";	
	public static final String OUTLETS_VIEW = OUTLETS_MODULE + SEPARATOR + INDEX;
	public static final String OUTLETS_MAPPING = SEPARATOR + OUTLETS_VIEW;
	public static final String VIEW_OUTLET_VIEW = OUTLETS_MODULE + SEPARATOR + VIEW;
	public static final String VIEW_OUTLET_MAPPING = SEPARATOR + VIEW_OUTLET_VIEW;
	
	public static final String HOME_MODULE = "home";	
	public static final String HOME_VIEW = HOME_MODULE + SEPARATOR + INDEX;
	public static final String HOME_MAPPING = SEPARATOR + HOME_VIEW;
	
	public static final String SCHEDULES_MODULE = "schedules";	
	public static final String SCHEDULES_VIEW = SCHEDULES_MODULE + SEPARATOR + INDEX;
	public static final String SCHEDULES_MAPPING = SEPARATOR + SCHEDULES_VIEW;
	
	public static final String SYSTEM_MODULE = "system";	
	public static final String SYSTEM_VIEW = SYSTEM_MODULE + SEPARATOR + INDEX;
	public static final String SYSTEM_MAPPING = SEPARATOR + SYSTEM_VIEW;
	
	public static final String USER_MODULE = "user";
	public static final String SYSTEM_USER_VIEW = SYSTEM_MODULE + SEPARATOR + USER_MODULE + SEPARATOR + VIEW;
	public static final String SYSTEM_USER_MAPPING = SEPARATOR + SYSTEM_USER_VIEW;
	
	public static final String USAGE_MODULE = "usage";	
	public static final String USAGE_VIEW = USAGE_MODULE + SEPARATOR + INDEX;
	public static final String USAGE_MAPPING = SEPARATOR + USAGE_VIEW;
	
	//binding constants
	public static final String USER_OUTLETS = "userOutlets";
	public static final String ROOMS = "rooms";
	public static final String NEW_OUTLET = "newOutlet";
	public static final String OUTLET = "outlet";
	public static final String SOCKETS = "sockets";	
	public static final String OUTLETS = "outlets";
	
}
