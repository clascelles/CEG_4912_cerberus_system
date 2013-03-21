package com.cerberus.server.workflow;

import com.cerberus.server.message.MessageContainer;
import com.cerberus.server.persistence.beans.Current;

public class CurrentWorkflow implements Workflow {
	
	public boolean persistCurrentMessage(MessageContainer messageContainer){
		
		//Convert the object into its right structure
		Current current = (Current) messageContainer.getMessageDataStructure();
		
		
		//Link the appropriate UserID to the current through Socket --> SochetAssignment -->Users
		//TODO Call UserService
		
		//Link
		
		
		
		
		return true;
	}

}
