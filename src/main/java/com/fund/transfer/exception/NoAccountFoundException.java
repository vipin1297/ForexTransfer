package com.fund.transfer.exception;

public class NoAccountFoundException extends RuntimeException	   {
	private static final long serialVersionUID = 1L;

	 public NoAccountFoundException(String exception) {
		
		super(exception);
	}

}
