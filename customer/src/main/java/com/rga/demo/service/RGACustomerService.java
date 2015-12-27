package com.rga.demo.service;

import java.util.List;

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

	public List<RGACustomer> loadAllCustomers() {
		return customerDao.findAll();
	}

	public RGACustomer loadUserById(Integer id) {
		return customerDao.findById(id);
	}
	
	public RGACustomer createCustomer(final String customerName,final String password,final String email) {
		return customerDao.create(customerName,password,email);
	}

	public RGACustomer update(final RGACustomer customer) {
		return customerDao.update(customer);
	}

	public void delete(Integer id) {
		customerDao.delete(id);
	}
	
	
}
