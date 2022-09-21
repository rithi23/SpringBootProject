package com.ideas2it.employee.repository;

import com.ideas2it.employee.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {

    @Query("Select trainer from Trainer trainer where trainer.isActive = true")
    public List<Trainer> getAllTrainers();

    @Query("select e from Trainer e where e.id = ?1 and e.isActive = true")
    public Trainer fetchTrainerById(long trainerId);

}
