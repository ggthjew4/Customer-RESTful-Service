package com.rga.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.intf.ICustomerLogoutService;
import com.rga.demo.common.intf.ITokenStoreService;

@Service
public class RGACustomerLogoutService implements ICustomerLogoutService {

	@Autowired
	private ITokenStoreService tokenStoreService;

	public void processLogout(final String customerName) {
		tokenStoreService.removeToken(customerName);
	}

}
