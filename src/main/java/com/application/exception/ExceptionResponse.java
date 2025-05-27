package com.application.exception;

public class ExceptionResponse {
	private String error;
	private String message;
	private int status;

	public ExceptionResponse(String error, String message, int status) {
		super();
		this.error = error;
		this.message = message;
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	// constructor, getters, setters
}
