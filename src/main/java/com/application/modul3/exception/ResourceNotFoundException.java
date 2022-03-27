package com.application.modul3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	// must be generated
	private static final long serialVersionUID = -4372590862909853742L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
