package com.springboot.BookMyShow.exceptions;

public class ShowSeatNotAvailableException extends Exception {
    public ShowSeatNotAvailableException(String message) {
        super(message);
    }
}
