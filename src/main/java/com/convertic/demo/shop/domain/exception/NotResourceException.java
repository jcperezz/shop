package com.convertic.demo.shop.domain.exception;

public class NotResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2556830283394037341L;

	public NotResourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotResourceException(String message) {
		super(message);
	}

}
