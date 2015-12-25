package com.rga.demo.common.intf;

import com.rga.demo.common.CustomerAuthentication;

public interface IUserLoginService {
	
	public CustomerAuthentication porcessLogin(final String username,final String password);

}
