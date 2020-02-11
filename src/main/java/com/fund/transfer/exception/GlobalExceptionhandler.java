package com.fund.transfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionhandler {
	@ControllerAdvice
	public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

		@ExceptionHandler(ImProperDataException.class)
		public ResponseEntity<ErrorResponse> InValidUserException(ImProperDataException ex) {

			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage(ex.getMessage());
			errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
		}

		@ExceptionHandler(NoAccountFoundException.class)
		public ResponseEntity<ErrorResponse> NoAccountFoundException(ImProperDataException ex) {

			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage(ex.getMessage());
			errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
