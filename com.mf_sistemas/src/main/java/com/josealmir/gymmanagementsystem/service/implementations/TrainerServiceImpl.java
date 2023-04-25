package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josealmir.gymmanagementsystem.model.person.Trainer;
import com.josealmir.gymmanagementsystem.repositories.TrainerRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer createTrainer(String trainerId, String speciality, Double salary, String certificationNumber) {
        Trainer trainer = trainerRepository.insert(new Trainer(trainerId, speciality, salary, certificationNumber));
        return trainer;
    }

    @Override
    public List<Trainer> allTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> trainerById(String trainerId) {
        return trainerRepository.findByTrainerId(trainerId);
    }
    @Override
    public void deleteByTrainerId(String trainerId) {
        Optional<Trainer> trainer = trainerRepository.findByTrainerId(trainerId);
        if(trainer.isPresent()) {
            trainerRepository.delete(trainer.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}
