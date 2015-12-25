package com.rga.demo.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.intf.ITokenHandlerService;
import com.rga.demo.common.intf.IUserService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class JWTTokenHandlerService implements ITokenHandlerService{
	
	@Autowired
	private IUserService userService;
	
	public String createJWTToken(final RGACustomer customer){
        long issuedAt = System.currentTimeMillis() / 1000L;
        long expiresAt = issuedAt + 180L;
		final Key key = MacProvider.generateKey();
		return Jwts.builder()
			.setIssuedAt(new Date(issuedAt))
			.setExpiration(new Date(expiresAt))
			.setSubject(customer.getUsername())
			.signWith(SignatureAlgorithm.HS512, key)
			.compact();
	}
	
	public RGACustomer parseCustomerFromToken(final String token) {
		final Key key = MacProvider.generateKey();
		final Claims body = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        final String username = body.getSubject();
        final RGACustomer customer = userService.loadUserByUsername(username);
        return customer;
    }
}
