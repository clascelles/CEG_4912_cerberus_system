package com.cerberus.module.generic.constants;

public class CerberusConstants {

	//Model constants
	public static final String TOP_BAR_BACKING_OBJECT = "topBarBackingObject";
	
	//Data constants
	public static final Integer OUTLET_OPERATION_MODE_ENABLED = 1;
	public static final Integer OUTLET_OPERATION_MODE_DISABLED = 2;
	public static final Integer OUTLET_OPERATION_MODE_MONITORING = 3;
	public static final Integer OUTLET_OPERATION_MODE_CHILD_SAFETY = 4;
	public static final Integer OUTLET_OPERATION_MODE_AUTHENTICATION = 5;
	
	public static final Integer ROOM_TYPE_FOYER = 1;
	public static final Integer ROOM_TYPE_FRONT_HALL = 2;
	public static final Integer ROOM_TYPE_LIVING_ROOM = 3;
	public static final Integer ROOM_TYPE_DINING_ROOM = 4;
	public static final Integer ROOM_TYPE_LAUNDRY_ROOM = 5;
	public static final Integer ROOM_TYPE_SITTING_ROOM = 6;
	public static final Integer ROOM_TYPE_KITCHEN = 7;
	public static final Integer ROOM_TYPE_STAIRWELL = 8;
	public static final Integer ROOM_TYPE_HALLWAY = 9;
	public static final Integer ROOM_TYPE_BATHROOM = 10;
	public static final Integer ROOM_TYPE_HALF_BATH = 11;
	public static final Integer ROOM_TYPE_ENSUITE_BATH = 12;
	public static final Integer ROOM_TYPE_MASTER_BEDROOM = 13;
	public static final Integer ROOM_TYPE_BEDROOM = 14;
	public static final Integer ROOM_TYPE_GUEST_BEDROOM = 15;
	public static final Integer ROOM_TYPE_BALCONY = 16;	
	
	//Navigation constants	
	public static final String REDIRECT = "redirect:/";
	
	public static final String ACCOUNTS_MODULE = "accounts";	
	public static final String ACCOUNTS_VIEW = ACCOUNTS_MODULE + "/index";
	public static final String ACCOUNTS_MAPPING = "/" + ACCOUNTS_VIEW;
	
	public static final String OUTLETS_MODULE = "outlets";	
	public static final String OUTLETS_VIEW = OUTLETS_MODULE + "/index";
	public static final String OUTLETS_MAPPING = "/" + OUTLETS_VIEW;
	
	public static final String HOME_MODULE = "home";	
	public static final String HOME_VIEW = HOME_MODULE + "/index";
	public static final String HOME_MAPPING = "/" + HOME_VIEW;
	
	public static final String SCHEDULES_MODULE = "schedules";	
	public static final String SCHEDULES_VIEW = SCHEDULES_MODULE + "/index";
	public static final String SCHEDULES_MAPPING = "/" + SCHEDULES_VIEW;
	
	public static final String SYSTEM_MODULE = "system";	
	public static final String SYSTEM_VIEW = SYSTEM_MODULE + "/index";
	public static final String SYSTEM_MAPPING = "/" + SYSTEM_VIEW;
	
	public static final String USAGE_MODULE = "usage";	
	public static final String USAGE_VIEW = USAGE_MODULE + "/index";
	public static final String USAGE_MAPPING = "/" + USAGE_VIEW;
	
}
