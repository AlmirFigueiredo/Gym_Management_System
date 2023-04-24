package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.josealmir.gymmanagementsystem.model.person.Trainer;
import com.josealmir.gymmanagementsystem.service.interfaces.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{
    private LinkedList<Trainer> trainers = new LinkedList<Trainer>();

    @Override
    public void createTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    @Override
    public Trainer findTrainerById(String trainerId) {
        for(Trainer trainer : this.trainers) {
            if(trainer.getId().equals(trainerId)) {
                return trainer;
            }
        }
        return null;
    }

    @Override
    public LinkedList<Trainer> getAllTrainer() {
        LinkedList<Trainer> copy = new LinkedList<Trainer>(trainers);
        return copy;
    }

    @Override
    public boolean updateTrainer(String trainerId, Trainer updateTrainer) {
        for(int i = 0; i < this.trainers.size(); i++) {
            if(this.trainers.get(i).getId().equals(trainerId)) {
                this.trainers.set(i, updateTrainer);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteTrainer(String trainerId) {
        for(int i = 0; i < this.trainers.size(); i++) {
            if(this.trainers.get(i).getId().equals(trainerId)) {
                this.trainers.remove(i);
                return true;
            }
        }
        return false;
    }
    
    
}
