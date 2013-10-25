package com.cerberus.module.generic.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.overview.backingobjects.TopBarBackingObject;

@Controller
@SessionAttributes ("bin")
public abstract class CerberusController {
	
	protected void initTopBar(Model model, User user) {		
		//Get user's full name for top bar display.
		TopBarBackingObject topBarBackingObject = new TopBarBackingObject();
		topBarBackingObject.setName(user.getFullName());
		model.addAttribute(CerberusConstants.TOP_BAR_BACKING_OBJECT, topBarBackingObject);
		model.addAttribute(CerberusConstants.IS_SYS_ADMIN, user.isSysAdmin());
	}

	protected HashMap<String, Object> bin;

	public HashMap<String, Object> getBin() {
		return bin;
	}

	public void setBin(HashMap<String, Object> bin) {
		this.bin = bin;
	}
	
	public User getUser() {
		return (User) bin.get("user");
	}	
	
}
