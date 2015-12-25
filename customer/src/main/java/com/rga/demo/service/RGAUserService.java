package com.rga.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.exception.CustomerNotFoundException;
import com.rga.demo.common.intf.IUserDao;
import com.rga.demo.common.intf.IUserService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class RGAUserService implements IUserService {

	@Autowired
	private IUserDao<RGACustomer> customerDao;

	public RGACustomer loadUserByUsername(String username) {
		final RGACustomer customer = customerDao.findByUsername(username);
		if (null == customer) {
			throw new CustomerNotFoundException(username);
		}
		return customer;
	}
}
