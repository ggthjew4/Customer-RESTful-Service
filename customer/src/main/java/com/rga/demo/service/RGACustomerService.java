package com.rga.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.exception.CustomerNotFoundException;
import com.rga.demo.common.intf.ICustomerDao;
import com.rga.demo.common.intf.ICustomerService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class RGACustomerService implements ICustomerService {

	@Autowired
	private ICustomerDao<RGACustomer> customerDao;

	public RGACustomer loadUserByCustomerName(String username) {
		final RGACustomer customer = customerDao.findByCustomerName(username);
		if (null == customer) {
			throw new CustomerNotFoundException(username);
		}
		return customer;
	}
}
