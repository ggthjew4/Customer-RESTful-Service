package com.rga.demo.common.intf;

import com.rga.demo.common.model.RGACustomer;

public interface ITokenHandlerService {
	
	public String createJWTToken(final RGACustomer customer);
	
	public RGACustomer parseUserFromToken(final String token);

}
