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
 *     This class have trainer id and trainee id i.e used to assign trainer to trainees
 * </p>
 *
 * @author : Rithikanth
 * @since : 01/10/2022
 */
@Data
public class AssociationModel {
    private Long trainerId;
    private Long traineeId;
}
