/**
 * <p>
 * This is the package for model class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.model;

import lombok.Data;

/**
 * <p>
 *     This model class assigns the user to the employee
 * </p>
 *
 * @author : RithiKanth
 * @since : 01/10/2022
 */
@Data
public class UserModel {
    private Long userId;
    private Long employeeId;
}
