/**
 * <p>
 * This is the package for repository class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.repository;

import com.ideas2it.employee.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *     This class acts as a repository for roles and it extends jpa repository and
 *     mechanism for storage, retrieval, search, update and delete operation on roles
 * </p>
 *
 * @author  : Rithikanth
 * @since : 01/10/2022
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
