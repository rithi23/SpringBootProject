package com.ideas2it.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String employeeId;
    private String name;
    private long phoneNumber;
    private String address;
    private String emailId;
    private String bloodGroup;
    private String dateOfBirth;
    private int age;
    private String position;
    private float previousExperience;
}
