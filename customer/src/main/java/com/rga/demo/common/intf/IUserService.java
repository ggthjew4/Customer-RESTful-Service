package com.rga.demo.common.intf;

import com.rga.demo.common.model.RGACustomer;

public interface IUserService {
	
	public RGACustomer loadUserByUsername(String username);

}
