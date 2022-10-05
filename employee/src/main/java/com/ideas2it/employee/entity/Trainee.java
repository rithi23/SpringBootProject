/**
 * <p>
 * This is the package for entity class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * <p>
 *     This class trainee specific details and it also inherits employee
 * </p>
 *
 * @author : RithiKanth
 * @since : 01/10/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainee extends Employee {
    private String trainingPeriod;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private Trainer trainer;
}
