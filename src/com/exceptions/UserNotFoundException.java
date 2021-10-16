package com.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
//		Custom exception
	}
}
