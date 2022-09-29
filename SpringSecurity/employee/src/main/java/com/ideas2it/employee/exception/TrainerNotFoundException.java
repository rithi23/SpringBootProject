package com.ideas2it.employee.exception;

public class TrainerNotFoundException extends Exception{
    public TrainerNotFoundException() {
    }

    public TrainerNotFoundException(String message) {
        super(message);
    }

    public TrainerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainerNotFoundException(Throwable cause) {
        super(cause);
    }

    public TrainerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
