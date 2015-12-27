package com.rga.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.intf.IAuthenticationStoreService;

@Repository
public class CustomerAuthenticationStoreService implements IAuthenticationStoreService {

	private final static Map<String, CustomerAuthentication> STORE_MAP = new ConcurrentHashMap<String, CustomerAuthentication>(
			10);

	public void addAuthentication(final String key, final CustomerAuthentication authentication) {
		STORE_MAP.put(key, authentication);
	}

	public CustomerAuthentication getAuthentication(final String key) {
		return STORE_MAP.get(key);
	}

	public void removeAuthentication(final String key) {
		STORE_MAP.remove(key);
	}

}
