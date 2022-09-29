package com.ideas2it.employee.service;

import com.ideas2it.employee.entity.Role;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.exception.RoleNotFoundException;
import com.ideas2it.employee.exception.TraineeNotFoundException;
import com.ideas2it.employee.exception.TrainerNotFoundException;
import com.ideas2it.employee.repository.RoleRepository;
import com.ideas2it.employee.repository.TraineeRepository;
import com.ideas2it.employee.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private User user;


//    @Autowired
//    private UserDetailsService userDetailsService;

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        trainer.setPassword(bCryptPasswordEncoder.encode(trainer.getPassword()));
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainee saveTrainee(Trainee trainee) {
        trainee.setPassword(bCryptPasswordEncoder.encode(trainee.getPassword()));
        return traineeRepository.save(trainee);
    }

    @Override
    public Trainer fetchTrainerById(long trainerId) throws TrainerNotFoundException {
        Optional<Trainer> trainer = Optional.ofNullable(trainerRepository.fetchTrainerById(trainerId));
        if(trainer.isEmpty()) {
            throw new TrainerNotFoundException("The trainer is not found in this id");
        }
        return trainer.get();
    }

    @Override
    public Trainee fetchTraineeById(long traineeId) throws TraineeNotFoundException {
        Optional<Trainee> trainee = Optional.ofNullable(traineeRepository.fetchTraineeById(traineeId));
        if(trainee.isEmpty()) {
            throw  new TraineeNotFoundException("Trainee is not found in this id");
        }
        return  trainee.get();
    }

    @Override
    public Trainer updateTrainerById(long trainerId, Trainer trainer) throws TrainerNotFoundException {
        Trainer trainerEmployee = fetchTrainerById(trainerId);
        if(Objects.nonNull(trainer.getEmployeeId()) && !"".equalsIgnoreCase(trainer.getEmployeeId())) {
            trainerEmployee.setEmployeeId(trainer.getEmployeeId());
        }

        if(Objects.nonNull(trainer.getName()) && !"".equalsIgnoreCase(trainer.getName())) {
            trainerEmployee.setName(trainer.getName());
        }

        trainerEmployee.setPhoneNumber(trainer.getPhoneNumber());

        if(Objects.nonNull(trainer.getAddress()) && !"".equalsIgnoreCase(trainer.getAddress())) {
            trainerEmployee.setAddress(trainer.getAddress());
        }

        if(Objects.nonNull(trainer.getEmailId()) && !"".equalsIgnoreCase(trainer.getEmailId())) {
            trainerEmployee.setEmailId(trainer.getEmailId());
        }

        if(Objects.nonNull(trainer.getBloodGroup()) && !"".equalsIgnoreCase(trainer.getBloodGroup())) {
            trainerEmployee.setBloodGroup(trainer.getBloodGroup());
        }


            trainerEmployee.setDateOfBirth(trainer.getDateOfBirth());

        trainerEmployee.setAge(trainer.getAge());

        if(Objects.nonNull(trainer.getPosition()) && !"".equalsIgnoreCase(trainer.getPosition())) {
            trainerEmployee.setPosition(trainer.getPosition());
        }

        trainerEmployee.setPreviousExperience(trainer.getPreviousExperience());

        if(Objects.nonNull(trainer.getProject()) && !"".equalsIgnoreCase(trainer.getProject())) {
            trainerEmployee.setProject(trainer.getProject());
        }

        if(Objects.nonNull(trainer.getProjectManager()) && !"".equalsIgnoreCase(trainer.getProjectManager())) {
            trainerEmployee.setProjectManager(trainer.getProjectManager());
        }

        return trainerRepository.save(trainerEmployee);
    }

    @Override
    public Trainee updateTraineeById(long traineeId, Trainee trainee) throws TraineeNotFoundException {
        Trainee traineeEmployee = fetchTraineeById(traineeId);
        if(Objects.nonNull(trainee.getEmployeeId()) && !"".equalsIgnoreCase(trainee.getEmployeeId())) {
            traineeEmployee.setEmployeeId(trainee.getEmployeeId());
        }

        if(Objects.nonNull(trainee.getName()) && !"".equalsIgnoreCase(trainee.getName())) {
            traineeEmployee.setName(trainee.getName());
        }

        traineeEmployee.setPhoneNumber(trainee.getPhoneNumber());

        if(Objects.nonNull(trainee.getAddress()) && !"".equalsIgnoreCase(trainee.getAddress())) {
            traineeEmployee.setAddress(trainee.getAddress());
        }

        if(Objects.nonNull(trainee.getEmailId()) && !"".equalsIgnoreCase(trainee.getEmailId())) {
            traineeEmployee.setEmailId(trainee.getEmailId());
        }

        if(Objects.nonNull(trainee.getBloodGroup()) && !"".equalsIgnoreCase(trainee.getBloodGroup())) {
            traineeEmployee.setBloodGroup(trainee.getBloodGroup());
        }


        traineeEmployee.setDateOfBirth(trainee.getDateOfBirth());

        traineeEmployee.setAge(trainee.getAge());

        if(Objects.nonNull(trainee.getPosition()) && !"".equalsIgnoreCase(trainee.getPosition())) {
            traineeEmployee.setPosition(trainee.getPosition());
        }

        traineeEmployee.setPreviousExperience(trainee.getPreviousExperience());

        if(Objects.nonNull(trainee.getTrainingPeriod()) && !"".equalsIgnoreCase(trainee.getTrainingPeriod())) {
            traineeEmployee.setTrainingPeriod(trainee.getTrainingPeriod());
        }

        return traineeRepository.save(traineeEmployee);
    }

    @Override
    public String deleteTrainerById(long trainerId) throws TrainerNotFoundException {
        Trainer trainer =  fetchTrainerById(trainerId);
        trainer.setActive(false);
        trainerRepository.save(trainer);
        return "Trainer deleted successfully";
    }

    @Override
    public String deleteTraineeById(long traineeId) throws TraineeNotFoundException {
        Trainee trainee = fetchTraineeById(traineeId);
        trainee.setActive(false);
        traineeRepository.save(trainee);
        return "Trainee deleted successfully";
   }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = trainerRepository.getAllTrainers();
        return trainers;
    }

    @Override
    public List<Trainee> getAllTrainees() {
        List<Trainee> trainees = traineeRepository.findByIsActiveTrue();
        return trainees;
    }

    @Override
    public Trainer fetchTrainerByEmployeeId(String trainerId) throws NullPointerException {
        return trainerRepository.findByEmployeeId(trainerId);
    }

    @Override
    public Trainee fetchTraineeByEmployeeId(String traineeId) {
        return traineeRepository.findByEmployeeId(traineeId);
    }

    @Override
    public void associateTrainerAndTrainee(long trainerId, long traineeId) throws TrainerNotFoundException, TraineeNotFoundException {
        Trainer trainer = fetchTrainerById(trainerId);
        Trainee trainee = fetchTraineeById(traineeId);
        trainee.setTrainer(trainer);
        trainer.getTrainees().add(trainee);
        traineeRepository.save(trainee);
        trainerRepository.save(trainer);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void addRoleToTrainer(Long employeeId, Long roleId) throws TrainerNotFoundException, RoleNotFoundException {
        Optional<Role> role = roleRepository.findById(roleId);
        if(role.isEmpty()) {
            throw new RoleNotFoundException("Invalid role id");
        }
        Trainer trainer = trainerRepository.fetchTrainerById(employeeId);
        trainer.getRoles().add(role.get());
        trainerRepository.save(trainer);
        roleRepository.save(role.get());
    }

    @Override
    public void addRoleToTrainee(Long employeeId, Long roleId) throws TraineeNotFoundException, RoleNotFoundException {
        Trainee trainee = fetchTraineeById(employeeId);
        Optional<Role> role = roleRepository.findById(roleId);
        if(role.isEmpty()) {
            throw new RoleNotFoundException("Invalid role id");
        }
        trainee.getRoles().add(role.get());
        traineeRepository.save(trainee);
    }


    public UserDetails loadUserByUsername(String employeeId) throws UsernameNotFoundException {
        Trainer trainer = trainerRepository.findByEmployeeId(employeeId);
        Trainee trainee = traineeRepository.findByEmployeeId(employeeId);
        if(trainer != null) {
            trainer.getRoles().forEach(role-> {
                user.getAuthorities().add(new SimpleGrantedAuthority(role.getRoleName()));
            });
            return new org.springframework.security.core.userdetails.User(trainer.getEmployeeId(),trainer.getPassword(), user.getAuthorities());
        } else if (trainee != null) {
            trainee.getRoles().forEach(role-> {
                user.getAuthorities().add(new SimpleGrantedAuthority(role.getRoleName()));
            });
            return new org.springframework.security.core.userdetails.User(trainee.getEmployeeId(),trainee.getPassword(), user.getAuthorities());
        } else {
            throw new UsernameNotFoundException("The user name is not found");
        }
    }

}






































































