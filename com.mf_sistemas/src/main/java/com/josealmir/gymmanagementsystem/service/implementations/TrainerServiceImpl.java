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
    public Trainer createTrainer(String speciality, Double salary, String certificationNumber, String fullName, 
    String phoneNumber, String address, String email) {
        int numberOfTrainers = allTrainers().size();
        String trainerId = String.format("%03d", numberOfTrainers+1);
        Trainer trainer = trainerRepository.insert(new Trainer(trainerId, speciality, salary, certificationNumber, fullName, 
        phoneNumber, address, email));
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
