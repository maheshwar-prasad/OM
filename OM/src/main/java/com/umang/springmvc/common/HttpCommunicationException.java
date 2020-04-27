package com.umang.springmvc.common;

public class HttpCommunicationException extends Exception {
	private static final long serialVersionUID = 1L;

	public HttpCommunicationException(String message) {
		super(message);
	}

	public HttpCommunicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpCommunicationException(Throwable cause) {
		super(cause);
	}
}
