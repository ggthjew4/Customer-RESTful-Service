package com.rga.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.rga.demo.common.intf.ITokenStoreService;

@Repository
public class JWTTokenStoreService implements ITokenStoreService {

	private final static Map<String, String> STORE_MAP = new ConcurrentHashMap<String, String>(
			10);

	public void addToken(String key, String token) {
		STORE_MAP.put(key, token);
	}

	public String getToken(String key) {
		return STORE_MAP.get(key);
	}

	public void removeToken(String key) {
		STORE_MAP.remove(key);
	}

}
