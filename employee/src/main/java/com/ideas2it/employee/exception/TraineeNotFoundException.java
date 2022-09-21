package com.ideas2it.employee.exception;

public class TraineeNotFoundException extends Exception{

    public TraineeNotFoundException() {
    }

    public TraineeNotFoundException(String message) {
        super(message);
    }

    public TraineeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TraineeNotFoundException(Throwable cause) {
        super(cause);
    }

    public TraineeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
