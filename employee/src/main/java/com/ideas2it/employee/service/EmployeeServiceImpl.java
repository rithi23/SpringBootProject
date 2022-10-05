package com.ideas2it.employee.service;

import com.ideas2it.employee.entity.Role;
import com.ideas2it.employee.entity.Trainee;
import com.ideas2it.employee.entity.Trainer;
import com.ideas2it.employee.entity.User;
import com.ideas2it.employee.exception.IdNotFoundException;
import com.ideas2it.employee.exception.TraineeNotFoundException;
import com.ideas2it.employee.exception.TrainerNotFoundException;
import com.ideas2it.employee.repository.RoleRepository;
import com.ideas2it.employee.repository.TraineeRepository;
import com.ideas2it.employee.repository.TrainerRepository;
import com.ideas2it.employee.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Trainee saveTrainee(Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Trainer fetchTrainerById(long trainerId) throws TrainerNotFoundException {
        Optional<Trainer> trainer = Optional.ofNullable(trainerRepository.fetchTrainerById(trainerId));
        if(trainer.isEmpty()) {
            throw new TrainerNotFoundException("The trainer is not found in this id");
        }
        return trainer.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Trainee fetchTraineeById(long traineeId) throws TraineeNotFoundException {
        Optional<Trainee> trainee = Optional.ofNullable(traineeRepository.fetchTraineeById(traineeId));
        if(trainee.isEmpty()) {
            throw  new TraineeNotFoundException("Trainee is not found in this id");
        }
        return  trainee.get();
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteTrainerById(long trainerId) throws TrainerNotFoundException {
        Trainer trainer =  fetchTrainerById(trainerId);
        trainer.setActive(false);
        trainerRepository.save(trainer);
        return "Trainer deleted successfully";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteTraineeById(long traineeId) throws TraineeNotFoundException {
        Trainee trainee = fetchTraineeById(traineeId);
        trainee.setActive(false);
        traineeRepository.save(trainee);
        return "Trainee deleted successfully";
   }

    /**
     * {@inheritDoc}
     */
    @Override
    public void associateTrainerAndTrainee(long trainerId, long traineeId) throws TrainerNotFoundException, TraineeNotFoundException {
        Trainer trainer = fetchTrainerById(trainerId);
        Trainee trainee = fetchTraineeById(traineeId);
        trainee.setTrainer(trainer);
        trainer.getTrainees().add(trainee);
        traineeRepository.save(trainee);
        trainerRepository.save(trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addRoleToUser(long employeeId, long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        Optional<User> user = userRepository.findById(employeeId);
        role.get().getUsers().add(user.get());
        user.get().getRoles().add(role.get());
        userRepository.save(user.get());
        roleRepository.save(role.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String saveRole(Role role) {
        roleRepository.save(role);
        return "Role saved successfully";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignUserToEmployee(Long employeeId, Long userId) throws IdNotFoundException {
        Optional<Trainer> trainer = trainerRepository.findById(employeeId);
        Optional<Trainee> trainee = traineeRepository.findById(employeeId);
        Optional<User> user = userRepository.findById(userId);
        if(trainer.isPresent() && user.isPresent()) {
            trainer.get().setUser(user.get());
            trainerRepository.save(trainer.get());
        } else if (trainee.isPresent() && user.isPresent()) {
            trainee.get().setUser(user.get());
            traineeRepository.save(trainee.get());
        }
        else {
            throw new IdNotFoundException("Cant able to find the id");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("The user name is not found in this id");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        System.out.println(authorities);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
}





































































