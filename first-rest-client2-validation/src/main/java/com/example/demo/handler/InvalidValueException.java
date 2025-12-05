
package com.example.demo.handler;

public class InvalidValueException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public InvalidValueException(String message) {
        super(message);
    }
}
