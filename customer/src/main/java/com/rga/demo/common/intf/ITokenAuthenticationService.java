package com.rga.demo.common.intf;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.model.RGACustomer;

public interface ITokenAuthenticationService {
	
	public String addAuthentication(final CustomerAuthentication authentication);
	
	public CustomerAuthentication getAuthentication(final String jwtToken);
	
	public CustomerAuthentication getAuthentication(final RGACustomer customer);
	

}
