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
 *     This class has role id and the user id i.e for assigning roles to the users
 * </p>
 *
 * @author  : Rithikanth
 * @since  : 01/10/2022
 */
@Data
public class RoleModel {
    private long employeeId;
    private long roleId;
}
