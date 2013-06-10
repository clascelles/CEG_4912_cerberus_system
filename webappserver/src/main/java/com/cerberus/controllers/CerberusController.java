package com.cerberus.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	
	
}
