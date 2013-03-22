package com.cerberus.server.service.system;

import com.cerberus.server.persistence.DAO.SocketAssignmentDAO;
import com.cerberus.server.persistence.DAO.SocketDAO;
import com.cerberus.server.persistence.DAO.UserDAO;
import com.cerberus.server.persistence.beans.*;
import com.cerberus.server.persistence.filter.SocketAssignmentFilter;

public class UserService {
	
	SocketDAO socketDAO;
	SocketAssignmentDAO socketAssignmentDAO;
	UserDAO userDAO;
	
	public UserService(){
		socketDAO = new SocketDAO();
		socketAssignmentDAO = new SocketAssignmentDAO();
		userDAO = new UserDAO();
		
	}
	
	public User getUserBySocketId(Integer socketId){
		
		//Get SocketID from the Socket Serial Number
		Socket socket = socketDAO.getById(socketId);
		
		//Get the current User assigned to the SocketID
		SocketAssignment socketAssignment = 
				socketAssignmentDAO.getByFilter(SocketAssignmentFilter.getUserFromSocketId(socketId));
		
		return socketAssignment.getUser();

	}

}
