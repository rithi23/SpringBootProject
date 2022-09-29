package com.ideas2it.employee.model;

import lombok.Data;

@Data
public class AddRoleToEmployeeModel {
    private Long employeeId;
    private Long roleId;
}
