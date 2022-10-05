/**
 * <p>
 * This is the package for entity class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * <p>
 *     This class contains attributes for error message
 * </p>
 *
 * @author : RithiKanth
 * @since : 01/10/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
