package com.cerberus.service.account;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.PersonalInformation;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.account.bean.UserSetting;
import com.cerberus.model.account.bean.UserType;
import com.cerberus.model.account.dao.LoginDAO;
import com.cerberus.model.account.dao.PersonalInformationDAO;
import com.cerberus.model.account.dao.UserDAO;
import com.cerberus.model.account.dao.UserSettingDAO;
import com.cerberus.model.account.dao.UserTypeDAO;
import com.cerberus.model.account.filter.LoginFilter;
import com.cerberus.model.account.filter.UserFilter;
import com.cerberus.model.outlets.bean.SocketAssignment;
import com.cerberus.model.outlets.dao.SocketAssignmentDAO;
import com.cerberus.model.outlets.dao.SocketDAO;
import com.cerberus.model.outlets.filter.SocketAssignmentFilter;

public class UserService {
	
	SocketDAO socketDAO;
	SocketAssignmentDAO socketAssignmentDAO;
	UserDAO userDAO;
	LoginDAO loginDAO;
	PersonalInformationDAO personalInformationDAO;
	UserTypeDAO userTypeDAO;
	UserSettingDAO userSettingDAO;
	
	public UserService(){
		socketDAO = new SocketDAO();
		socketAssignmentDAO = new SocketAssignmentDAO();
		userDAO = new UserDAO();
		loginDAO = new LoginDAO();
		personalInformationDAO = new PersonalInformationDAO();
		userTypeDAO = new UserTypeDAO();
		userSettingDAO = new UserSettingDAO();
		
	}
	
	public User getUserBySocketId(Integer socketId){
		
		SocketAssignment socketAssignment = 
				socketAssignmentDAO.getByFilter(SocketAssignmentFilter.getBySocketId(socketId));
		
		return socketAssignment.getUser();

	}
	
	//***************************************************
	//USER
	//***************************************************
	
	public User getUserById(Integer userId){
		return userDAO.getById(userId);
	}
	
	public Integer insertUser(User user){
		return userDAO.save(user);
	}
	
	public User updateUser(User user){
		return userDAO.merge(user);
	}
	
	public void deleteUser(User user){
		userDAO.delete(user);
	}
	
	public List<User> getAllUser() {
		return userDAO.getAll();
	}
	
	public User getUserByLoginId(Integer loginId){
		return userDAO.getByFilter(UserFilter.getUserByLoginId(loginId));
	}

	//***************************************************
	//LOGIN
	//***************************************************
	
	public Integer insertLogin(Login login){
		return loginDAO.save(login);
	}
	
	public Login updateLogin(Login login){
		return loginDAO.merge(login);
	}
	
	public void deleteLogin(Login login){
		loginDAO.delete(login);
	}
	
	public Login getLoginById(Integer loginId) {
		return loginDAO.getById(loginId);
	}

	public List<Login> getAllLogin() {
		return loginDAO.getAll();
	}
	
	public Login getLoginByUsernameAndPassword(String username, String password){
		DetachedCriteria criteria = LoginFilter.getLoginByUsernameAndPassword(username, password);
		return loginDAO.getByFilter(criteria);
	}
	
	public List<Login> getLoginsBySystemId(Integer systemId) {
		return loginDAO.getAllByFilter(LoginFilter.getLoginsBySystemId(systemId));
	}

	//***************************************************
	//PERSONAL INFORMATION
	//***************************************************

	public Integer insertPersonalInformation(PersonalInformation personalInformation){
		return personalInformationDAO.save(personalInformation);
	}
	
	public PersonalInformation updatePersonalInformation(PersonalInformation personalInformation){
		return personalInformationDAO.merge(personalInformation);
	}
	
	public void deletePersonalInformation(PersonalInformation personalInformation){
		personalInformationDAO.delete(personalInformation);
	}
	
	
	//***************************************************
	//USER TYPE
	//***************************************************

	public Integer insertUserType(UserType userType) {
		return userTypeDAO.save(userType);
	}
	
	public UserType getUserTypeById(Integer userTypeId){
		return userTypeDAO.getById(userTypeId);
	}	
	
	public List<UserType> getAllUserTypes() {
		return userTypeDAO.getAll();
	}

	//***************************************************
	//USER SETTING
	//***************************************************
	
	public Integer insertUserSetting(UserSetting userSetting){
		return userSettingDAO.save(userSetting);
	}
	
	public UserSetting updateUserSetting(UserSetting userSetting){
		return userSettingDAO.merge(userSetting);
	}
	
	public void deleteUserSetting(UserSetting userSetting){
		userSettingDAO.delete(userSetting);
	}
	
}
