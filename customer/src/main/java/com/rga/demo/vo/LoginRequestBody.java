package com.rga.demo.vo;

import java.io.Serializable;

public class LoginRequestBody implements Serializable{

	private static final long serialVersionUID = -5318639271818154712L;

    private String customerName;
    
    private String password;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String userName) {
		this.customerName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
