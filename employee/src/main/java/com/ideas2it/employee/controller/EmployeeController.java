package com.ideas2it.employee.controller;

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
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/trainer")
    public Trainer saveTrainer(@RequestBody Trainer trainer) {
        return employeeService.saveTrainer(trainer);
    }

    @PostMapping("/trainee")
    public Trainee saveTrainee(@RequestBody Trainee trainee) {
        return employeeService.saveTrainee(trainee);
    }

    @GetMapping("/trainer/{trainerId}")
    public Trainer fetchTrainerById(@PathVariable("trainerId") long trainerId) throws TrainerNotFoundException {
        return employeeService.fetchTrainerById(trainerId);
    }

    @GetMapping("/trainee/{traineeId}")
    public Trainee fetchTraineeById(@PathVariable("traineeId") long traineeId) throws TraineeNotFoundException {
        return employeeService.fetchTraineeById(traineeId);
    }

    @PutMapping("/trainer/{trainerId}")
    public Trainer updateTrainerById(@PathVariable("trainerId") long trainerId, @RequestBody Trainer trainer) throws TrainerNotFoundException {
        return employeeService.updateTrainerById(trainerId, trainer);
    }

    @PutMapping("/trainee/{traineeId}")
    public Trainee updateTraineeById(@PathVariable("traineeId") long traineeId,
                                     @RequestBody Trainee trainee) throws TraineeNotFoundException {
        return employeeService.updateTraineeById(traineeId, trainee);
    }

    @DeleteMapping("/trainer/{trainerId}")
    public String deleteTrainerById(@PathVariable("trainerId") long trainerId) throws TrainerNotFoundException {
        return employeeService.deleteTrainerById(trainerId);
    }

    @DeleteMapping("/trainee/{traineeId}")
    public String deleteTraineeById(@PathVariable("traineeId") long traineeId) throws TraineeNotFoundException {
        return employeeService.deleteTraineeById(traineeId);
    }

    @PutMapping("/associate")
    public void association(@RequestBody AssociationModel associationModel) throws
                               TrainerNotFoundException,TraineeNotFoundException {
        employeeService.associateTrainerAndTrainee(associationModel.getTrainerId(),associationModel.getTraineeId());
    }

    @PostMapping("/saveRole")
    public String saveRole(@RequestBody Role role) {
        return employeeService.saveRole(role);
    }

    @PutMapping("/addRole")
    public String addRoleToUser(@RequestBody RoleModel roleModel) {
        employeeService.addRoleToUser(roleModel.getEmployeeId(),roleModel.getRoleId());
        return "Role added successfully";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        employeeService.addUser(user);
        return "user added successfully";
    }

    @PutMapping("/assignUser")
    public void assignUserToEmployee(@RequestBody UserModel userModel) throws IdNotFoundException {
        employeeService.assignUserToEmployee(userModel.getEmployeeId(),userModel.getUserId());
    }
}
