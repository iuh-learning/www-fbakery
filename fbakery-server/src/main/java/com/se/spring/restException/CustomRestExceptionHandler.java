package com.se.spring.restException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomRestExceptionHandler {
	// Custom exception if condition fail
	@ExceptionHandler
	public ResponseEntity<CustomErrorRespone> handleException(CustomNotFoundException exc) {
		CustomErrorRespone error = new CustomErrorRespone();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomErrorRespone>(error, HttpStatus.BAD_REQUEST);
	}
}
