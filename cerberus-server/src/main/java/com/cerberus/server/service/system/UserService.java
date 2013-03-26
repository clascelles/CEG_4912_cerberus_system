package com.cerberus.server.service.system;

import com.cerberus.server.persistence.DAO.LoginDAO;
import com.cerberus.server.persistence.DAO.SocketAssignmentDAO;
import com.cerberus.server.persistence.DAO.SocketDAO;
import com.cerberus.server.persistence.DAO.UserDAO;
import com.cerberus.server.persistence.beans.*;
import com.cerberus.server.persistence.filter.SocketAssignmentFilter;

public class UserService {
	
	SocketDAO socketDAO;
	SocketAssignmentDAO socketAssignmentDAO;
	UserDAO userDAO;
	LoginDAO loginDAO;
	
	public UserService(){
		socketDAO = new SocketDAO();
		socketAssignmentDAO = new SocketAssignmentDAO();
		userDAO = new UserDAO();
		loginDAO = new LoginDAO();
		
	}
	
	public User getUserBySocketId(Integer socketId){
		
		//Get SocketID from the Socket Serial Number
		Socket socket = socketDAO.getById(socketId);
		
		//Get the current User assigned to the SocketID
		SocketAssignment socketAssignment = 
				socketAssignmentDAO.getByFilter(SocketAssignmentFilter.getUserFromSocketId(socketId));
		
		return socketAssignment.getUser();

	}
	
	//***************************************************
	//USER
	//***************************************************
	
	public User getUserById(Integer userId){
		return userDAO.getById(userId);
	}
	
	public void insertUser(User user){
		userDAO.save(user);
	}
	
	public User updateUser(User user){
		return userDAO.merge(user);
	}
	
	public void deleteUser(User user){
		userDAO.delete(user);
	}
	
	//***************************************************
	//LOGIN
	//***************************************************
	
	public void insertLogin(Login login){
		loginDAO.save(login);
	}
	
	public Login updateLogin(Login login){
		return loginDAO.merge(login);
	}
	
	public void deleteLogin(Login login){
		loginDAO.delete(login);
	}

}
