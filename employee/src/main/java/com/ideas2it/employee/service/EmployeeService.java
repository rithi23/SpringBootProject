package com.ideas2it.employee.service;

import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.exception.TraineeNotFoundException;
import com.ideas2it.employee.exception.TrainerNotFoundException;

public interface EmployeeService {
    Trainer saveTrainer( Trainer trainer);

    Trainee saveTrainee(Trainee trainee);


    Trainer fetchTrainerById(long trainerId) throws TrainerNotFoundException;

    Trainee fetchTraineeById(long traineeId) throws TraineeNotFoundException;

    Trainer updateTrainerById(long trainerId, Trainer trainer) throws TrainerNotFoundException;

    Trainee updateTraineeById(long traineeId, Trainee trainee) throws TraineeNotFoundException;

    String deleteTrainerById(long trainerId) throws TrainerNotFoundException;

    String deleteTraineeById(long traineeId) throws TraineeNotFoundException;
}
