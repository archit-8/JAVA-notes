
package com.example.demo.handler;

import java.sql.Date;
import java.time.LocalDate;

public class MyErrorResponse {

	private String message;
	private String errorCode;
	private long time;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
}
