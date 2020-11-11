package com.java.exception;

public class InsuranceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsuranceNotFoundException(String message) {
			super(message);
		}

	public InsuranceNotFoundException(String message, Throwable t) {
			super(message, t);
		}

}
