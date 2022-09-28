package com.ideas2it.employee.model;

import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import lombok.Data;

@Data
public class AssociationModel {
    private Long trainerId;
    private Long traineeId;
}
