package com.josealmir.gymmanagementsystem.service;

import java.util.LinkedList;

import com.josealmir.gymmanagementsystem.model.person.Trainer;

public class TrainerServiceImpl implements TrainerService{
    private LinkedList<Trainer> trainers = new LinkedList<Trainer>();

    @Override
    public void createTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    @Override
    public Trainer findTrainerById(String memberId) {
        
       
    }

    @Override
    public LinkedList<Trainer> getAllTrainer() {
        LinkedList<Trainer> copy = new LinkedList<Trainer>(trainers);
        return copy;
    }

    @Override
    public boolean updateTrainer(String trainerId, Trainer updateTrainer) {
        
       
    }

    @Override
    public boolean deleteTrainer(String memberId) {
        
        
    }
    
    
}
