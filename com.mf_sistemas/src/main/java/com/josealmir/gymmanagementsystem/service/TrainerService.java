package com.josealmir.gymmanagementsystem.service;

import com.josealmir.gymmanagementsystem.model.person.Trainer;
import java.util.LinkedList;

public interface TrainerService {
    void createMember(Trainer trainer);
    Trainer findTrainerById(String memberId);
    LinkedList<Trainer> getAllTrainer();
    boolean updateTrainer(String trainerId, Trainer updateTrainer);
    boolean deleteMember(String memberId);
}
