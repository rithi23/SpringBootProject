package com.ideas2it.employee.repository;

import com.ideas2it.employee.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {
    @Query(value = "select * from trainee where trainee.is_Active = true" , nativeQuery = true)
    public List<Trainee> getAllTrainees();

    @Query("select trainee from Trainee trainee where trainee.id = ?1 and isActive = true")
    public Trainee fetchTraineeById(long traineeId);
}
