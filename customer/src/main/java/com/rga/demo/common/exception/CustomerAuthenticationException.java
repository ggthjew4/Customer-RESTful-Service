package com.rga.demo.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CustomerAuthenticationException extends RuntimeException {

	private static final long serialVersionUID = -9052367867893519929L;
	

	public CustomerAuthenticationException(final String userName) {
		super("could not find user '" + userName + "'.");
	}

}
