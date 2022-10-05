/**
 * <p>
 * This is the package for entity class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * <p>
 *     This class describes the role for the users and has role attributes
 * </p>
 *
 * @author : Rithikanth
 * @since : 01/10/2022
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;

    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}