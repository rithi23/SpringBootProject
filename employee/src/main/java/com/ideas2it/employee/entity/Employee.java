package com.ideas2it.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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
    private String password;
    private String bloodGroup;
    private LocalDate dateOfBirth;
    private int age;
    private String position;
    private float previousExperience;
    private boolean isActive = true;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Role> roles = new ArrayList<>();
}
