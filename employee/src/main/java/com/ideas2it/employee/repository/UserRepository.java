/**
 * <p>
 * This is the package for repository class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.repository;

import com.ideas2it.employee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *     This class acts as a repository for user and it extends jpa repository and
 *     mechanism for storage, retrieval, search, update and delete operation on user
 * </p>
 *
 * @author : Rithi
 * @since : 01/10/2022
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
}
