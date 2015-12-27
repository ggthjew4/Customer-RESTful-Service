package com.rga.demo.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.demo.common.intf.ICustomerService;
import com.rga.demo.common.intf.ITokenHandlerService;
import com.rga.demo.common.model.RGACustomer;

@Service
public class JWTTokenHandlerService implements ITokenHandlerService{
	
	@Autowired
	private ICustomerService userService;
	
	private String securityKey;
	
	public JWTTokenHandlerService(){
		securityKey = "tempSecrets";
	}
	
	public String createJWTToken(final RGACustomer customer){
		final Date nowDate = new Date();
		return Jwts.builder()
			.setIssuedAt(nowDate)
			.setExpiration(DateUtils.addDays(nowDate, 1))
			.setSubject(customer.getUsername())
			.signWith(SignatureAlgorithm.HS512, securityKey)
			.compact();
	}
	
	public RGACustomer parseCustomerFromToken(final String token) {
		final Claims body = Jwts.parser()
                .setSigningKey(securityKey)
                .parseClaimsJws(token)
                .getBody();
        final String username = body.getSubject();
        final RGACustomer customer = userService.loadUserByCustomerName(username);
        return customer;
    }
}
