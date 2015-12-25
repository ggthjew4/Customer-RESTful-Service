package com.rga.demo.service.security;

import org.junit.Test;

import com.rga.demo.common.intf.ITokenHandlerService;
import com.rga.demo.common.model.RGACustomer;


public class JWTTokenHandlerServiceTest {
	
	
	@Test
	public void testCreateJWTToken(){
		final RGACustomer customer = new RGACustomer();
		ITokenHandlerService service = new JWTTokenHandlerService();
		String token = service.createJWTToken(customer);
		System.out.print(token);
		
	}

}
