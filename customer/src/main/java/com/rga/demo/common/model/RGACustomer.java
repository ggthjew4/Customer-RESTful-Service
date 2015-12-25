package com.rga.demo.common.model;

import java.io.Serializable;
import java.util.Date;

public class RGACustomer implements Serializable{
	
	private static final long serialVersionUID = 6848754731320916890L;

	private String username;
	
	private String password;
	
	private Date expiration;
	
	public RGACustomer() {
		super();
	}

	public RGACustomer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	

}
