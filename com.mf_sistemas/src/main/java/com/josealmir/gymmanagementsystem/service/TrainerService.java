package com.josealmir.gymmanagementsystem.service;

import com.josealmir.gymmanagementsystem.model.person.Trainer;
import java.util.LinkedList;

public interface TrainerService {
    void createTrainer(Trainer trainer);
    Trainer findTrainerById(String trainerId);
    LinkedList<Trainer> getAllTrainer();
    boolean updateTrainer(String trainerId, Trainer updateTrainer);
    boolean deleteTrainer(String trainerId);
}
