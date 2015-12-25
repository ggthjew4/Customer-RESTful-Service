package com.rga.demo.service.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.Exception.CustomerNotFoundException;
import com.rga.demo.common.intf.ITokenAuthenticationService;
import com.rga.demo.common.intf.ITokenHandlerService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class JWTTokenAuthenticationService implements ITokenAuthenticationService {
	
	private static final String JWT_AUTH_HEADER_NAME = "X-AUTH-TOKEN";

	@Autowired
	private ITokenHandlerService tokenHandlerService;

	public String addAuthentication(final HttpServletResponse response,final CustomerAuthentication authentication) {
		final RGACustomer customer = authentication.getCustomer();
		final String token = tokenHandlerService.createJWTToken(customer);
		response.addHeader(JWT_AUTH_HEADER_NAME, token);
		return token;
	}

	public CustomerAuthentication getAuthentication(final String jwtToken) {
        if (jwtToken != null) {
            final RGACustomer customer = tokenHandlerService.parseUserFromToken(jwtToken);
            if (customer != null) {
                return new CustomerAuthentication(customer);
            }
        }
        throw new CustomerNotFoundException("");
	}
	
	
	

}
