package com.ideas2it.employee.exception;

import com.ideas2it.employee.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class RestResponseTraineeEntityException {
    @ExceptionHandler(TraineeNotFoundException.class)
    public ResponseEntity<ErrorMessage> traineeNotFoundException(TraineeNotFoundException traineeNotFoundException, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, traineeNotFoundException.getMessage()) ;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
