package com.rga.demo.common.intf;

import javax.servlet.http.HttpServletResponse;

import com.rga.demo.common.CustomerAuthentication;

public interface ITokenAuthenticationService {
	
	public String addAuthentication(final HttpServletResponse response,final CustomerAuthentication authentication);
	
	public CustomerAuthentication getAuthentication(final String jwtToken);

}
