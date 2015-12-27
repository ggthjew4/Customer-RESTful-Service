package com.rga.demo.common.intf;

import com.rga.demo.common.model.RGACustomer;

public interface ICustomerService {
	
	public RGACustomer loadUserByCustomerName(String customerName);

}
