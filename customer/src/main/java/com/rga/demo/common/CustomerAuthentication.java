package com.rga.demo.common;

import com.rga.demo.common.model.RGACustomer;

public class CustomerAuthentication {

	private final RGACustomer customer;
	
	private String token;
	
	private boolean authenticated = false;
	
	public CustomerAuthentication(final RGACustomer pCustomer){
		this.customer = pCustomer;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public RGACustomer getCustomer() {
		return customer;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
