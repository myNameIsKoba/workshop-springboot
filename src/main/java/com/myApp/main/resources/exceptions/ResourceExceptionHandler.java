package com.myApp.main.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myApp.main.Services.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandartErrorException> 
		resourceNotFound(ResourceNotFoundException error, HttpServletRequest request){
		
		String errorMsg = "Resource not found ";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartErrorException 
			err = new StandartErrorException(
						Instant.now(),
						status.value(),
						errorMsg,
						error.getMessage(),
						request.getRequestURI()
					);
		return ResponseEntity.status(status).body(err);
	}
}
