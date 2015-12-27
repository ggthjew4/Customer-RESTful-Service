package com.rga.demo.common.intf;

import java.util.List;

import com.rga.demo.common.model.RGACustomer;

public interface ICustomerService {
	
	public RGACustomer loadUserByCustomerName(String customerName);
	
	public RGACustomer loadUserById(Integer id);
	
	public List<RGACustomer> loadAllCustomers();
	
	public RGACustomer createCustomer(final String customerName,final String password,final String email);
	
	public RGACustomer update(final RGACustomer customer);
	
	public void delete(final Integer id);
}
