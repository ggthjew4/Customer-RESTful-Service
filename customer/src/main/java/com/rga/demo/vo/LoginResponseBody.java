package com.rga.demo.vo;

import java.io.Serializable;

public class LoginResponseBody implements Serializable{
	
	private static final long serialVersionUID = -2922588378251650074L;

	private String token;
	
	private String customerName;
	
	private String message;
	
	public LoginResponseBody(){}

	public LoginResponseBody(String token, String customerName,String message) {
		super();
		this.token = token;
		this.customerName = customerName;
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return customerName;
	}

	public void setUserName(String userName) {
		this.customerName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
}
