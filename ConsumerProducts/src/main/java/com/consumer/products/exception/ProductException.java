package com.consumer.products.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = -5948408229365475681L;
	
	private String message;
	
	private HttpStatus status;
	
	public ProductException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
