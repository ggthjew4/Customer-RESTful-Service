package com.rga.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.exception.CustomerAuthenticationException;
import com.rga.demo.common.intf.ITokenAuthenticationService;
import com.rga.demo.common.intf.ICustomerLoginService;
import com.rga.demo.common.intf.ICustomerService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class RGACustomerLoginService implements ICustomerLoginService {

	@Autowired
	private ITokenAuthenticationService tokenAuthenticationService;

	@Autowired
	private ICustomerService customerService;

	public CustomerAuthentication porcessLogin(final String username,final String password) {
		validateCustomerCertification(username, password);
		final CustomerAuthentication authentication = tokenAuthenticationService.getAuthentication(customerService.loadUserByCustomerName(username));
		tokenAuthenticationService.addAuthentication(authentication);
		return authentication;
	}

	private void validateCustomerCertification(final String username,final String password) {
		final RGACustomer customer = customerService.loadUserByCustomerName(username);
		if (!customer.getPassword().equals(password)) {
			throw new CustomerAuthenticationException("Customer password was incorrect!");
		}
	}

}
