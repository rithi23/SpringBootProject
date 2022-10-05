/**
 * <p>
 * This is the package for repository class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.repository;

import com.ideas2it.employee.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *     This class acts as a repository for trainer and it extends jpa repository and
 *     mechanism for storage, retrieval, search, update and delete operation on trainer
 * </p>
 *
 * @author : Rithi
 * @since : 01/10/2022
 */
@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {

    @Query("Select trainer from Trainer trainer where trainer.isActive = true")
    public List<Trainer> getAllTrainers();

    @Query("select trainer from Trainer trainer where trainer.id = ?1 and trainer.isActive = true")
    public Trainer fetchTrainerById(long trainerId);

    Trainer findByEmployeeId(String trainerId);
}
