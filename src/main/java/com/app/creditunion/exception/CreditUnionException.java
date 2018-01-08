package com.app.creditunion.exception;

import org.springframework.http.HttpStatus;

public class CreditUnionException extends RuntimeException {
	private static final long serialVersionUID = -4430028575982092168L;
	private final HttpStatus status;
	/**
	 * The default constructor
	 */
	public CreditUnionException() {
		super();
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	/**
	 * Constructs an exception instance with message
	 * @param message
	 */
	public CreditUnionException(String message) {
		super(message);
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	/**
	 * Constructs an exception with cause
	 * @param cause
	 */
	public CreditUnionException(Throwable cause) {
		super(cause);
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	/**
	 * Constructs an exception with cause and message
	 * @param message
	 * @param cause
	 */
	public CreditUnionException(String message, Throwable cause) {
		super(message, cause);
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	/**
	 * Constructs an exception with cause and message and HTTP status
	 * @param message
	 * @param cause
	 * @param status
	 */
	public CreditUnionException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.status = status;
	}
	/**
	 * Constructs an exception with HTTP status
	 * @param status
	 */
	public CreditUnionException(HttpStatus status) {
		this.status = status;
	}
	public HttpStatus getStatus() {
		return status;
	}
}
