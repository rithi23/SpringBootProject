/**
 * <p>
 * This is the package for exception class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.exception;

/**
 * <p>
 *     This class handles the custom exception and throws the error message when the trainee id is invalid
 * </p>
 *
 * @author : RithiKanth
 * @since  : 01/10/2022
 */
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
