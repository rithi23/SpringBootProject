/**
 * <p>
 * This is the package for repository class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.repository;

import com.ideas2it.employee.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *     This class acts as a repository for trainee and it extends jpa repository and
 *     mechanism for storage, retrieval, search, update and delete operation on trainee
 * </p>
 */
@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {
    @Query(value = "select * from trainee where trainee.is_Active = true" , nativeQuery = true)
    public List<Trainee> getAllTrainees();

    @Query("select trainee from Trainee trainee where trainee.id = ?1 and isActive = true")
    public Trainee fetchTraineeById(long traineeId);

    List<Trainee> findByIsActiveTrue();

    Object findByIdAndIsActive(long traineeId, boolean b);

    Trainee findByEmployeeId(String traineeId);
}
