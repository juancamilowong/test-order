package com.order.exception;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception ex, WebRequest request){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR FROM CONTROLLER ADVICE");
    }
	
	@ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> ConnextExceptionHandler(Exception ex, WebRequest request){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("CONNECTION ERROR FROM CONTROLLER ADVICE");
    }
	
	@ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<String> ResourceExceptionHandler(Exception ex, WebRequest request){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Resource access error for " + ex.getLocalizedMessage());
    }
	
}
