package com.josealmir.gymmanagementsystem.service.interfaces;

import com.josealmir.gymmanagementsystem.model.person.Trainer;
import java.util.List;
import java.util.Optional;

public interface TrainerService {
    Trainer createTrainer(String speciality, Double salary, String certificationNumber, String fullName, 
    String phoneNumber, String address, String email);
    List<Trainer> allTrainers();
    Optional<Trainer> trainerById(String trainerId);
    Trainer updateTrainer(String trainerId, Trainer trainerRequest);
    void deleteByTrainerId(String trainerId);
}
