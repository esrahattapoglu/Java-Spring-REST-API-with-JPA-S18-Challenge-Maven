package com.workintech.fswebs18challengemaven.exceptions;

public class CardErrorResponse {

    private String message;

    public CardErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}