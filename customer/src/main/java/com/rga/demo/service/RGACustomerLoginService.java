package com.rga.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.exception.CustomerAuthenticationException;
import com.rga.demo.common.intf.ITokenAuthenticationService;
import com.rga.demo.common.intf.IUserLoginService;
import com.rga.demo.common.intf.IUserService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class RGACustomerLoginService implements IUserLoginService {

	@Autowired
	private ITokenAuthenticationService tokenAuthenticationService;

	@Autowired
	private IUserService customerService;

	public CustomerAuthentication porcessLogin(final String username,final String password) {
		validateCustomerCertification(username, password);
		final CustomerAuthentication authentication = tokenAuthenticationService.getAuthentication(customerService.loadUserByUsername(username));
		tokenAuthenticationService.addAuthentication(authentication);
		return authentication;
	}

	private void validateCustomerCertification(final String username,final String password) {
		final RGACustomer customer = customerService.loadUserByUsername(username);
		if (!customer.getPassword().equals(password)) {
			throw new CustomerAuthenticationException("Customer password was incorrect!");
		}
	}

}
