package com.rga.demo.service;

import org.springframework.stereotype.Service;

import com.rga.demo.common.intf.IUserService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class RGAUserService implements IUserService {

	public RGACustomer loadUserByUsername(String username) {
		return null;
	}

}
