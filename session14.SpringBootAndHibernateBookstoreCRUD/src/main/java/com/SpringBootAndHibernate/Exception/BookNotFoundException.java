package com.SpringBootAndHibernate.Exception;

import org.springframework.stereotype.Component;

@Component
public class BookNotFoundException extends RuntimeException {

	 
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException() {
		super();
	}
	
	public BookNotFoundException(String msg) {
		super(msg);
	}

}
