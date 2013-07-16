package com.cerberus.module.account.backingobjects;

public class LoginBackingObject {

	//Variables matching the view object/representation
	private String username;
	private String password;
	private int forgetPassword;
	
	//Getters and Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getForgetPassword() {
		return forgetPassword;
	}
	public void setForgetPassword(int forgetPassword) {
		this.forgetPassword = forgetPassword;
	}
	
	
}
