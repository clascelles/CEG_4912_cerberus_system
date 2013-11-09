package com.cerberus.module.generic.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.overview.backingobjects.TopBarBackingObject;

@Controller
public abstract class CerberusController {
	
	protected void initTopBar(Model model, User user) {		
		//Get user's full name for top bar display.
		TopBarBackingObject topBarBackingObject = new TopBarBackingObject();
		topBarBackingObject.setName(user.getFullName());
		model.addAttribute(CerberusConstants.TOP_BAR_BACKING_OBJECT, topBarBackingObject);
		model.addAttribute(CerberusConstants.IS_SYS_ADMIN, user.isSysAdmin());
	}
	
	public User getUser(HttpServletRequest request){
		return (User) request.getSession().getAttribute("user");
	}
	
}
