package com.hexaware.eventManager.exception;

import java.time.LocalDateTime;

import lombok.ToString;

@ToString
public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String errorCode;
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public ErrorDetails(LocalDateTime timestamp, String message, String path, String errorCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
		this.errorCode = errorCode;
	}
}