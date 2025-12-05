package com.example.demo.advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


public class MyRestExcpetionHandler{
@ExceptionHandler(NullPointerException.class)
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
protected ResponseEntity<MyErrorResponse> errorHandler(NullPointerException e, WebRequest req) {
    System.out.println("from npe");
    MyErrorResponse errorResponse=new MyErrorResponse();

    errorResponse.setMessage(e.getMessage());
    errorResponse.setErrorCode("406");
    errorResponse.setTime(new java.util.Date());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
}



@ExceptionHandler(value = { Exception.class })

@ResponseStatus(HttpStatus.NOT_FOUND)
protected ResponseEntity<Object> errorHandler(Exception e, WebRequest req) {
	System.out.println("from Exc");
    MyErrorResponse errorResponse=new MyErrorResponse();
	errorResponse.setMessage(e.getMessage());
	errorResponse.setErrorCode("404");
	errorResponse.setTime(new java.util.Date());
	return new ResponseEntity<>(errorResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	// return //handleExceptionInternal(e,error,new HttpHeaders(),
	// HttpStatus.NOT_FOUND,req);

}
}