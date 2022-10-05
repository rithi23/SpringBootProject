/**
 * <p>
 * This is the package for exception class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.exception;

/**
 * <p>
 *     Used to handle the custom exception when the id is invalid
 * </p>
 *
 * @author  : Rithikanth
 * @since : 01/10/2022
 */
public class IdNotFoundException extends Exception{
    public IdNotFoundException(String message) {
        super(message);
    }
}
