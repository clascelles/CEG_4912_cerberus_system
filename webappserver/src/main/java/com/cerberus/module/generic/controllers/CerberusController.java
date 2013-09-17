package com.cerberus.module.generic.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cerberus.model.account.bean.User;

@Controller
@SessionAttributes ("bin")
public abstract class CerberusController {

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
