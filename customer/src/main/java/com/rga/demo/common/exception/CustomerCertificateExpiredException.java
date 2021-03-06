package com.rga.demo.common.exception;

public class CustomerCertificateExpiredException extends RuntimeException {

	private static final long serialVersionUID = 5277478922794010450L;

	public CustomerCertificateExpiredException(final String customerName) {
		super("[ "+customerName+" ] must login again!");
	}

}
