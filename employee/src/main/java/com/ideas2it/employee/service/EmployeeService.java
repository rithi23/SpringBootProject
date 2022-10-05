/**
 * <p>
 * This is the package for service class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.service;

import com.ideas2it.employee.entity.Role;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.entity.User;
import com.ideas2it.employee.exception.IdNotFoundException;
import com.ideas2it.employee.exception.TraineeNotFoundException;
import com.ideas2it.employee.exception.TrainerNotFoundException;

/**
 * <p>
 *     This interface contains several methods and that should be implemented by the class which implements
 *     and it also contains business logics
 * </p>
 *
 * @author : Rithikanth
 * @since : 01/10/2022
 */
public interface EmployeeService {

    /**
     * <p>
     *    gets the input from user and  saves the trainer employee in database
     * </p>
     *
     * @param trainer - trainer object which contains all attributes defined in trainer pojo
     * @return trainer employee
     */
    Trainer saveTrainer( Trainer trainer);

    /**
     * <p>
     *    gets the input from user and  saves the trainer employee in database
     * </p>
     *
     * @param trainee - trainee object which contains all attributes defined in trainee pojo
     * @return trainee employee
     */
    Trainee saveTrainee(Trainee trainee);

    /**
     * <p>
     *     This method is used to get a specific trainer employee
     * </p>
     * @param trainerId - trainer id is the primary id for trainer
     * @return trainer - trainer employee
     * @throws TrainerNotFoundException - when id is invalid
     */
    Trainer fetchTrainerById(long trainerId) throws TrainerNotFoundException;

    /**
     * <p>
     *     This methods used to get a specific trainee employee
     * </p>
     *
     * @param traineeId trainee id is the primary id for the trainee
     * @return - trainee employee
     * @throws TraineeNotFoundException -  when id is invalid
     */
    Trainee fetchTraineeById(long traineeId) throws TraineeNotFoundException;

    /**
     * <p>
     *     used to update the trainer
     * </p>
     *
     * @param trainerId - id of the trainer
     * @param trainer - trainer object with new inputs
     * @return - trainer with the updated values
     * @throws TrainerNotFoundException - throws when id is invalid
     */
    Trainer updateTrainerById(long trainerId, Trainer trainer) throws TrainerNotFoundException;

    /**
     * <p>
     *     used to update trainee
     * </p>
     *
     * @param traineeId - id of the trainee
     * @param trainee - trainee object with new inputs
     * @return - trainee with updated values
     * @throws TraineeNotFoundException - throws when id is invalid
     */
    Trainee updateTraineeById(long traineeId, Trainee trainee) throws TraineeNotFoundException;

    /**
     * <p>
     *     Used to delete trainer
     * </p>
     *
     * @param trainerId - id of the trainer
     * @return - {@link String} message whether trainer is deleted or not
     * @throws TrainerNotFoundException - throws when id is invalid
     */
    String deleteTrainerById(long trainerId) throws TrainerNotFoundException;

    /**
     * <p>
     *     Used to delete trainee
     * </p>
     * @param traineeId - id of the trainee
     * @return - {@link String} message whether trainee is deleted or not
     * @throws TraineeNotFoundException - throws when id is invalid
     */
    String deleteTraineeById(long traineeId) throws TraineeNotFoundException;

    /**
     * <p>
     *     Used for assigning trainer to trainees
     * </p>
     *
     * @param traineeId - id of the trainee
     * @param trainerId - id of the trainer
     * @throws TrainerNotFoundException - throws when id is invalid
     * @throws TraineeNotFoundException - throws when id is invalid
     */
    void associateTrainerAndTrainee(long trainerId, long traineeId) throws TrainerNotFoundException, TraineeNotFoundException;

    /**
     * <p>
     *     used to assign roles to users
     * </p>
     * @param employeeId - id of the user
     * @param roleId - id of the role
     */
    void addRoleToUser(long employeeId, long roleId);

    /**
     * <p>
     *     used to save role
     * </p>
     * @param role - role entity contains roles for the users
     * @return - {@link String} message whether the role is saved in database or not
     */
    String saveRole(Role role);

    /**
     * <p>
     *     adding user in the database
     * </p>
     * @param user - User entity contains user attributes
     */
    void addUser(User user);

    /**
     * <p>
     *     Used to assign user to employee
     * </p>
     * @param employeeId - id of the employee
     * @param userId - id of the user
     * @throws IdNotFoundException
     */
    void assignUserToEmployee(Long employeeId, Long userId) throws IdNotFoundException;
}
