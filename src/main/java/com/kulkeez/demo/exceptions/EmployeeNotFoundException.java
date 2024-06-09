package com.kulkeez.demo.exceptions;

public class EmployeeNotFoundException extends RuntimeException  {

	public EmployeeNotFoundException(String errorMsg) {
		super(errorMsg);
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}