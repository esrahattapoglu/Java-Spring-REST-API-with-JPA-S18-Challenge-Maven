package com.workintech.fswebs18challengemaven.exceptions;

import org.springframework.http.HttpStatus;

public class CardException extends RuntimeException {

    private HttpStatus httpStatus;

    public CardException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}