package com.myApp.main.Services.exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super(" Resource or Controller not found: " + id);
	}
}
