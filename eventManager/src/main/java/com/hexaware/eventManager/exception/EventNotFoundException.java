package com.hexaware.eventManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EventNotFoundException extends Exception{

	
	public EventNotFoundException(String fieldName , int fieldValue) {
		super(String.format("Event not found with %s: %s",fieldName,fieldValue));

	}
}
