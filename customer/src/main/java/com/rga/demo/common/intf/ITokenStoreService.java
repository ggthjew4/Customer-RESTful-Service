package com.rga.demo.common.intf;

public interface ITokenStoreService {
	
	public void addToken(final String key,final String token);
	
	public void removeToken(final String key);
	
	public String getToken(final String key);

}
