/**
 * <p>
 * This is the package for controller class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas2it.employee.entity.Role;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.entity.User;
import com.ideas2it.employee.exception.IdNotFoundException;
import com.ideas2it.employee.exception.TraineeNotFoundException;
import com.ideas2it.employee.exception.TrainerNotFoundException;
import com.ideas2it.employee.model.AssociationModel;
import com.ideas2it.employee.model.RoleModel;
import com.ideas2it.employee.model.UserModel;
import com.ideas2it.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * <p>
 *     This rest controller class is responsible for dealing with REST-API's
 * </p>
 *
 * @author : RithiKanth
 * @since : 01/10/2022
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * <p>
     *    gets the input from user and  saves the trainer employee in database
     * </p>
     *
     * @param trainer - trainer object which contains all attributes defined in trainer pojo
     * @return trainer employee
     */
    @PostMapping("/trainer")
    public Trainer saveTrainer(@RequestBody Trainer trainer) {
        return employeeService.saveTrainer(trainer);
    }

    /**
     * <p>
     *    gets the input from user and  saves the trainer employee in database
     * </p>
     *
     * @param trainee - trainee object which contains all attributes defined in trainee pojo
     * @return trainer employee
     */
    @PostMapping("/trainee")
    public Trainee saveTrainee(@RequestBody Trainee trainee) {
        return employeeService.saveTrainee(trainee);
    }

    /**
     * <p>
     *     This method is used to get a specific trainer employee
     * </p>
     * @param trainerId - trainer id is the primary id for trainer
     * @return trainer - trainer employee
     * @throws TrainerNotFoundException - when id is invalid
     */
    @GetMapping("/trainer/{trainerId}")
    public Trainer fetchTrainerById(@PathVariable("trainerId") long trainerId) throws TrainerNotFoundException {
        return employeeService.fetchTrainerById(trainerId);
    }

    /**
     * <p>
     *     This methods used to get a specific trainee employee
     * </p>
     *
     * @param traineeId trainee id is the primary id for the trainee
     * @return - trainee employee
     * @throws TraineeNotFoundException -  when id is invalid
     */
    @GetMapping("/trainee/{traineeId}")
    public Trainee fetchTraineeById(@PathVariable("traineeId") long traineeId) throws TraineeNotFoundException {
        return employeeService.fetchTraineeById(traineeId);
    }

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
    @PutMapping("/trainer/{trainerId}")
    public Trainer updateTrainerById(@PathVariable("trainerId") long trainerId, @RequestBody Trainer trainer) throws TrainerNotFoundException {
        return employeeService.updateTrainerById(trainerId, trainer);
    }

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
    @PutMapping("/trainee/{traineeId}")
    public Trainee updateTraineeById(@PathVariable("traineeId") long traineeId,
                                     @RequestBody Trainee trainee) throws TraineeNotFoundException {
        return employeeService.updateTraineeById(traineeId, trainee);
    }

    /**
     * <p>
     *     Used to delete trainer
     * </p>
     *
     * @param trainerId - id of the trainer
     * @return - trainee with making isActive as false
     * @throws TrainerNotFoundException - throws when id is invalid
     */
    @DeleteMapping("/trainer/{trainerId}")
    public String deleteTrainerById(@PathVariable("trainerId") long trainerId) throws TrainerNotFoundException {
        return employeeService.deleteTrainerById(trainerId);
    }

    /**
     * <p>
     *     Used to delete trainee
     * </p>
     * @param traineeId - id of the trainee
     * @return - {@link String} message whether trainee is deleted or not
     * @throws TraineeNotFoundException - throws when id is invalid
     */
    @DeleteMapping("/trainee/{traineeId}")
    public String deleteTraineeById(@PathVariable("traineeId") long traineeId) throws TraineeNotFoundException {
        return employeeService.deleteTraineeById(traineeId);
    }

    /**
     * <p>
     *     Used for assigning trainer to trainees
     * </p>
     *
     * @param associationModel - model class contains trainer and trainee id
     * @throws TrainerNotFoundException - throws when id is invalid
     * @throws TraineeNotFoundException - throws when id is invalid
     */
    @PutMapping("/associate")
    public void association(@RequestBody AssociationModel associationModel) throws
                               TrainerNotFoundException,TraineeNotFoundException {
        employeeService.associateTrainerAndTrainee(associationModel.getTrainerId(),associationModel.getTraineeId());
    }

    /**
     * <p>
     *     used to save roles
     * </p>
     *
     * @param role - role entity contains roles for the users
     * @return - {@link String} message whether the role is saved in database or not
     */
    @PostMapping("/saveRole")
    public String saveRole(@RequestBody Role role) {
        return employeeService.saveRole(role);
    }

    /**
     * <p>
     *     used to assign roles to the users
     * </p>
     * @param roleModel - a model class contains role id and user id
     * @return - {@link String} message whether the role is assigned to the user or not
     */
    @PutMapping("/addRole")
    public String addRoleToUser(@RequestBody RoleModel roleModel) {
        employeeService.addRoleToUser(roleModel.getEmployeeId(),roleModel.getRoleId());
        return "Role added successfully";
    }

    /**
     * <p>
     *     adding user in the database
     * </p>
     * @param user - User entity contains user attributes
     * @return - {@link  String} message whether the user is added to database or not
     */
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        employeeService.addUser(user);
        return "user added successfully";
    }

    /**
     * <p>
     *     assigning the user to the employee
     * </p>
     * @param userModel - model class which contains user id and employee id
     * @throws IdNotFoundException - throws when id is invalid
     */
    @PutMapping("/assignUser")
    public void assignUserToEmployee(@RequestBody UserModel userModel) throws IdNotFoundException {
        employeeService.assignUserToEmployee(userModel.getEmployeeId(),userModel.getUserId());
    }
}
