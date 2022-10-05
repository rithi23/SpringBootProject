/**
 * <p>
 * This is the package for entity class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * <p>
 *     This class contains employees attributes and it is an employee pojo
 * </p>
 *
 * @author  : RithiKanth B C
 * @since  : 01/10/2022
 */
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
    private LocalDate dateOfBirth;
    private int age;
    private String position;
    private float previousExperience;
    private boolean isActive = true;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
