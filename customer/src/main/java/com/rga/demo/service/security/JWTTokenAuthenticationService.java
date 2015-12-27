package com.rga.demo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.exception.CustomerCertificateExpiredException;
import com.rga.demo.common.exception.CustomerNotFoundException;
import com.rga.demo.common.intf.IAuthenticationStoreService;
import com.rga.demo.common.intf.ICustomerService;
import com.rga.demo.common.intf.ITokenAuthenticationService;
import com.rga.demo.common.intf.ITokenHandlerService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class JWTTokenAuthenticationService implements ITokenAuthenticationService {
	
	@Autowired
	private ITokenHandlerService tokenHandlerService;
	
	@Autowired
	private IAuthenticationStoreService authenticationStoreService;
	
	@Autowired
	private ICustomerService customerService;
	

	public String addAuthentication(final CustomerAuthentication authentication) {
		final RGACustomer customer = authentication.getCustomer();
		final String jwtToken = tokenHandlerService.createJWTToken(customer);
		authenticationStoreService.addAuthentication(customer.getUsername(), authentication);
		return jwtToken;
	}

	public CustomerAuthentication getAuthentication(final String jwtToken) {
        if (jwtToken != null) {
            final RGACustomer customer = tokenHandlerService.parseCustomerFromToken(jwtToken);
            final CustomerAuthentication authentication = authenticationStoreService.getAuthentication(customer.getUsername());
            if(null == authentication){
            	throw new CustomerCertificateExpiredException(customer.getUsername());
            }
            return authenticationStoreService.getAuthentication(customer.getUsername());
        }
        throw new CustomerNotFoundException("Customer isn't found!");
	}
	
	public CustomerAuthentication getAuthentication(final RGACustomer customer) {
		final CustomerAuthentication authentication = new CustomerAuthentication(customer);
		final String jwtToken = tokenHandlerService.createJWTToken(customer);
		authentication.setAuthenticated(true);
		authentication.setToken(jwtToken);
		return authentication;
	}
}
