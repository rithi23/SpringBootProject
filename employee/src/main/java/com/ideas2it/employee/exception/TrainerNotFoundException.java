/**
 * <p>
 * This is the package for exception class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.exception;

/**
 * <p>
 *     This class handles the custom exception and throws the error message when the trainer id is invalid
 * </p>
 *
 * @author : RithiKanth
 * @since  : 01/10/2022
 */
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
