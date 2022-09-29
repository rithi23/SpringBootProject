package com.ideas2it.employee.service;

import com.ideas2it.employee.entity.Role;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.entity.User;
import com.ideas2it.employee.exception.IdNotFoundException;
import com.ideas2it.employee.exception.TraineeNotFoundException;
import com.ideas2it.employee.exception.TrainerNotFoundException;

import java.util.List;

public interface EmployeeService {
    Trainer saveTrainer( Trainer trainer);

    Trainee saveTrainee(Trainee trainee);


    Trainer fetchTrainerById(long trainerId) throws TrainerNotFoundException;

    Trainee fetchTraineeById(long traineeId) throws TraineeNotFoundException;

    Trainer updateTrainerById(long trainerId, Trainer trainer) throws TrainerNotFoundException;

    Trainee updateTraineeById(long traineeId, Trainee trainee) throws TraineeNotFoundException;

    String deleteTrainerById(long trainerId) throws TrainerNotFoundException;

    String deleteTraineeById(long traineeId) throws TraineeNotFoundException;

    List<Trainer> getAllTrainers();

    List<Trainee> getAllTrainees();

    Trainer fetchTrainerByEmployeeId(String trainerId);

    Trainee fetchTraineeByEmployeeId(String traineeId);

    void associateTrainerAndTrainee(long trainerId, long traineeId) throws TrainerNotFoundException, TraineeNotFoundException;

    void addRoleToUser(long employeeId, long roleId);

    String saveRole(Role role);

    void addUser(User user);

    void assignUserToEmployee(Long employeeId, Long userId) throws IdNotFoundException;
}
