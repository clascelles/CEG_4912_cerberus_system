package com.cerberus.daemon.constants;

import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.outlets.bean.SocketOperationMode;

public class OperationModeUtil {
	
	public static Integer getValue(OutletOperationMode outletMode,
			SocketOperationMode socketMode) {
		Integer value = 0;
		
		if(outletMode != null) {
			if(outletMode.getId() == OutletOperationMode.MONITORING) {
				value += SocketOperatingMode.MONITORING.getIntValue();
			} else if(outletMode.getId() == OutletOperationMode.RESTRICTED) {
				value += SocketOperatingMode.RESTRICTED.getIntValue();
			} else if(outletMode.getId() == OutletOperationMode.SAFETY) {
				value += SocketOperatingMode.SAFETY.getIntValue();
			}
		}
		
		if(socketMode != null) {
			if(socketMode.getId() == SocketOperationMode.MANUAL_OFF_ID) {
				value += SocketOperatingMode.OFF.getIntValue();
			} else if(socketMode.getId() == SocketOperationMode.MANUAL_ON_ID) {
				value += SocketOperatingMode.ON.getIntValue();
			} else if(socketMode.getId() == SocketOperationMode.DEFAULT_ID) {
				value += SocketOperatingMode.NORMAL.getIntValue();
			}
		}
		
		return value;
	}	
	
	public static SocketOperatingMode getSocketOperatingMode(
			OutletOperationMode outletMode,
			SocketOperationMode socketMode) {
		Integer value = getValue(outletMode, socketMode);
		
		if((value % SocketOperatingMode.ON.getIntValue()) 
				== SocketOperatingMode.OFF.getIntValue()) {
			
			return SocketOperatingMode.OFF;
			
		} else if((value % SocketOperatingMode.NORMAL.getIntValue()) 
				== SocketOperatingMode.ON.getIntValue()) {
			
			return SocketOperatingMode.ON;
			
		} else if((value % SocketOperatingMode.RESTRICTED.getIntValue()) 
				== SocketOperatingMode.NORMAL.getIntValue()) {
			
			return SocketOperatingMode.NORMAL;
			
		} else if((value % SocketOperatingMode.SAFETY.getIntValue()) 
				== SocketOperatingMode.RESTRICTED.getIntValue()) {
			
			return SocketOperatingMode.RESTRICTED;
			
		} else if((value % SocketOperatingMode.MONITORING.getIntValue()) 
				== SocketOperatingMode.SAFETY.getIntValue()) {
			
			return SocketOperatingMode.SAFETY;
			
		} else {
			
			return SocketOperatingMode.MONITORING;
			
		}
	}
}
