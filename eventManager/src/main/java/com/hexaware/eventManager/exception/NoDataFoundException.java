package com.hexaware.eventManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoDataFoundException extends Exception{

	public NoDataFoundException(String message) {
		super(message);
	}

}
