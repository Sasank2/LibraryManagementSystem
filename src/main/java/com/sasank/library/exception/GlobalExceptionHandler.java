package com.sasank.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //scan this class for global exception handlers.
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LibraryException.class)
	public ResponseEntity<String> handleLibraryExeception(LibraryException ex) {
		
		return new ResponseEntity<>(
				ex.getMessage(),
				HttpStatus.BAD_REQUEST);
	}
}
