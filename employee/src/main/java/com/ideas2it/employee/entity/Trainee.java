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
