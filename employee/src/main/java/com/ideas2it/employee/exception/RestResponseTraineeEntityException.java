/**
 * <p>
 * This is the package for exception class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.exception;

import com.ideas2it.employee.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * <p>
 *     This class act as advice to the controller and when the id is invalid
 *     or it cant be found in the data base it shows the error message and response status
 * </p>
 *
 * @author  : Rithikanth
 * @since  : 01/10/2022
 */
@ControllerAdvice
@ResponseStatus
public class RestResponseTraineeEntityException {

    /**
     * <p>
     *     used to throw error message as response when id is invalid
     * </p>
     *
     * @param traineeNotFoundException - a custom exception class which throws error message when trainee id is invalid
     * @param request - request from the server
     * @return - error message bounded with Response entity
     */
    @ExceptionHandler(TraineeNotFoundException.class)
    public ResponseEntity<ErrorMessage> traineeNotFoundException(TraineeNotFoundException traineeNotFoundException, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, traineeNotFoundException.getMessage()) ;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
