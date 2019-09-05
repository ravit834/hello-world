package com.consumer.products.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ProductAdvice {
	
	public static final Logger log = LoggerFactory.getLogger(ProductAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public void generateException(final Exception exception) {		
		log.error(exception.getMessage());
	}
	
	@ExceptionHandler(ProductException.class)
	public void generateUserDefinedException(final ProductException productException) {
		log.error(productException.getMessage());
	}

}
