package com.rga.demo.common.intf;

import com.rga.demo.common.CustomerAuthentication;

public interface IAuthenticationStoreService {
	
	public void addAuthentication(final String key,final CustomerAuthentication authentication);
	
	public void removeAuthentication(final String key);
	
	public CustomerAuthentication getAuthentication(final String key);

}
