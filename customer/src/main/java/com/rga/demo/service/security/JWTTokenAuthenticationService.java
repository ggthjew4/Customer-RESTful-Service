package com.rga.demo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.exception.CustomerNotFoundException;
import com.rga.demo.common.intf.ITokenAuthenticationService;
import com.rga.demo.common.intf.ITokenHandlerService;
import com.rga.demo.common.intf.ITokenStoreService;
import com.rga.demo.common.intf.ICustomerService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class JWTTokenAuthenticationService implements ITokenAuthenticationService {
	
	@Autowired
	private ITokenHandlerService tokenHandlerService;
	
	@Autowired
	private ITokenStoreService tokenStoreService;
	
	@Autowired
	private ICustomerService customerService;
	

	public String addAuthentication(final CustomerAuthentication authentication) {
		final RGACustomer customer = authentication.getCustomer();
		final String jwtToken = tokenHandlerService.createJWTToken(customer);
		tokenStoreService.addToken(customer.getUsername(), jwtToken);
		return jwtToken;
	}

	public CustomerAuthentication getAuthentication(final String jwtToken) {
        if (jwtToken != null) {
            final RGACustomer customer = tokenHandlerService.parseCustomerFromToken(jwtToken);
            if (customer != null) {
                return new CustomerAuthentication(customer);
            }
        }
        throw new CustomerNotFoundException("");
	}
	
	public CustomerAuthentication getAuthentication(final RGACustomer customer) {
		final CustomerAuthentication authentication = new CustomerAuthentication(customer);
		final String jwtToken = tokenHandlerService.createJWTToken(customer);
		authentication.setAuthenticated(true);
		authentication.setToken(jwtToken);
		return authentication;
	}
}
