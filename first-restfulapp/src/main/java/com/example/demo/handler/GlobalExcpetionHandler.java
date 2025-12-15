package com.example.demo.handler;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcpetionHandler {
	
	
	
	

@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ResponseEntity<Map<String, String>> handleHandler(IllegalArgumentException ex) {
	
	MyErrorResponse myerror=new MyErrorResponse();
	myerror.setErrorCode("400");
	myerror.setMessage(ex.getMessage());
	myerror.setTime(new java.util.Date().getTime());
	Map<String, String> error = new HashMap<>();
    error.put("error", ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
}

	

}
