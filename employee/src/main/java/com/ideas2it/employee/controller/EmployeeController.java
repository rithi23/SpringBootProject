package com.ideas2it.employee.controller;

import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.exception.TraineeNotFoundException;
import com.ideas2it.employee.exception.TrainerNotFoundException;
import com.ideas2it.employee.service.EmployeeService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String display() {
        return "Welcome to employee Management";
    }

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
    public String fetchTraineeById(@PathVariable("traineeId") long traineeId) throws TraineeNotFoundException {
        System.out.println(employeeService.fetchTraineeById(traineeId));
        return "tue";
    }

    @PutMapping("/trainer/{trainerId}")
    public Trainer updateTrainerById(@PathVariable("trainerId") long trainerId, @RequestBody Trainer trainer) throws TrainerNotFoundException {
        return employeeService.updateTrainerById(trainerId, trainer);
    }

    @PutMapping("/trainee/{traineeId}")
    public Trainee updateTraineeById(@PathVariable("traineeId") long traineeId, @RequestBody Trainee trainee) throws TraineeNotFoundException {
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

    @GetMapping("/trainers/")
    public List<Trainer> getAllTrainers() {
        return employeeService.getAllTrainers();
    }

    @GetMapping("/trainees/")
    public List<Trainee> getAllTrainees() {
        return employeeService.getAllTrainees();
    }

//    @PutMapping("/trainee/associate/{id}")
//    public void assignTrainerForTrainees(@PathVariable("id") long id, @RequestBody Trainee trainee) throws TraineeNotFoundException {
//        List<Trainer> trainers = getAllTrainers();
//        List<Trainee> trainees = getAllTrainees();
//        trainers.forEach(n->{
//            System.out.println(n.getId() + " " +n.getName());
//        });
//
//        Trainee traineeEmployee = employeeService.fetchTraineeById(id);
//    }
}
