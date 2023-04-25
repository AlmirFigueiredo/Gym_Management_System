package com.josealmir.gymmanagementsystem.service.interfaces;

import com.josealmir.gymmanagementsystem.model.person.Trainer;
import java.util.List;
import java.util.Optional;

public interface TrainerService {
    Trainer createTrainer(String trainerId, String speciality, Double salary, String certificationNumber);
    List<Trainer> allTrainers();
    Optional<Trainer> trainerById(String trainerId);
    void deleteTrainerById(String trainerId);
}
