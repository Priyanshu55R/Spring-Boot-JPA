package com.examples.spring.jpa.exceptions;

public class EmployeeNotFoundExceptions extends RuntimeException{
	
	 private static final long serialVersionUID = 1L;
	 public EmployeeNotFoundExceptions() {
	        super("Employee does not exist");
	    }

}
