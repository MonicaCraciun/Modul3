package com.application.modul3.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handlerPersonNotFoundException(ResourceNotFoundException exception) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), httpStatus.value(), httpStatus.getReasonPhrase(),
				exception.getMessage());
		return new ResponseEntity<>(error, httpStatus);
	}

	// handle specific exception
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleValidationException(ValidationException exception) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), httpStatus.value(), httpStatus.getReasonPhrase(),
				exception.getMessage());

		return new ResponseEntity<>(error, httpStatus);
	}

}
