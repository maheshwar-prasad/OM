package com.umang.springmvc.common;

public class JsonTransformerException extends Exception {
	private static final long serialVersionUID = 1L;

	public JsonTransformerException(String message) {
		super(message);
	}

	public JsonTransformerException(String message, Throwable cause) {
		super(message, cause);
	}

	public JsonTransformerException(Throwable cause) {
		super(cause);
	}
}
