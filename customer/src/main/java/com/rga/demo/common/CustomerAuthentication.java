package com.rga.demo.common;

import java.util.Date;

import com.rga.demo.common.model.RGACustomer;

public class CustomerAuthentication {

	private final RGACustomer customer;
	
	private boolean authenticated = true;
	
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

	public boolean isExpired() {
		return this.getCustomer().getExpiration().before(new Date());
	}

}
