/**
 * <p>
 * This is the package for entity class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * <p>
 *     This class has trainer specific details and it also inherits the employee pojo
 * </p>
 *
 * @author : Rithikanth
 * @since : 01/10/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer extends Employee {
    private String projectManager;
    private String project;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "trainer")
    private List<Trainee> trainees;
}
