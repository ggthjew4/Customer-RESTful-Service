package com.rga.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.rga.demo.common.CustomerAuthentication;
import com.rga.demo.common.JWTConstant;
import com.rga.demo.common.Exception.CustomerAuthenticationException;
import com.rga.demo.common.Exception.CustomerCertificateExpiredException;
import com.rga.demo.common.intf.ITokenAuthenticationService;

@Component
public class StatelessAuthenticationFilter extends GenericFilterBean {
	
	@Autowired
	private ITokenAuthenticationService tokenAuthenticationService;
       
    public StatelessAuthenticationFilter() {
        super();
    }
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		final CustomerAuthentication authentication = tokenAuthenticationService.getAuthentication(getRequestJWTToken(request));
		final String customerName = authentication.getCustomer().getUsername();
		if(!authentication.isAuthenticated()){
			throw new CustomerAuthenticationException(customerName);
		}
		if(authentication.isExpired()){
			throw new CustomerCertificateExpiredException(customerName);
		}
        filterChain.doFilter(request, response);
	}
    
    private String getRequestJWTToken(final ServletRequest request){
    	return ((HttpServletRequest)request).getHeader(JWTConstant.JWT_AUTH_HEADER_NAME);
    }


}