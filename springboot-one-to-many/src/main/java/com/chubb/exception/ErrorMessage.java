package com.chubb.exception;

public class ErrorMessage extends RuntimeException  {
	public ErrorMessage(String message) {
        super(message);
    }
}
