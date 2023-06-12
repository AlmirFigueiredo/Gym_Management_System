package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josealmir.gymmanagementsystem.model.person.Trainer;
import com.josealmir.gymmanagementsystem.repositories.TrainerRepository;
import com.josealmir.gymmanagementsystem.requests.TrainerRequest;
import com.josealmir.gymmanagementsystem.service.interfaces.TrainerService;
import com.josealmir.gymmanagementsystem.utils.GymLogger;

@Service
public class TrainerServiceImpl implements TrainerService {

    private GymLogger logger = GymLogger.getInstance();
    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer createTrainer(String speciality, Double salary, String certificationNumber, String fullName,
            String phoneNumber, String address, String email) {
        String trainerId = generateNextMemberId();
        if (trainerId != null) {
            Trainer trainer = trainerRepository.insert(new Trainer(trainerId, speciality, salary, certificationNumber, fullName, 
            phoneNumber, address, email));
            logger.log("New Trainer created, Trainer ID: " + trainerId);
            return trainer;
        } else {
            throw new IllegalStateException();
        }
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
    public Trainer updateTrainer(String trainerId, TrainerRequest trainerRequest) {
        Optional<Trainer> optionalTrainer = trainerRepository.findByTrainerId(trainerId);
        if (optionalTrainer.isPresent()) {
            Trainer trainer = optionalTrainer.get();
            trainer.setSpeciality(trainerRequest.getSpeciality());
            trainer.setSalary(trainerRequest.getSalary());
            trainer.setCertificationNumber(trainerRequest.getCertificationNumber());
            trainer.setFullName(trainerRequest.getFullName());
            trainer.setPhoneNumber(trainerRequest.getPhoneNumber());
            trainer.setAddress(trainerRequest.getAddress());
            trainer.setEmail(trainerRequest.getEmail());
            logger.log("Trainer updated, Trainer ID: " + trainerId);
            return trainerRepository.save(trainer);
        } else {
            throw new NoSuchElementException();
        }
    }
        
    @Override
    public void deleteByTrainerId(String trainerId) {
        Optional<Trainer> trainer = trainerRepository.findByTrainerId(trainerId);
        if (trainer.isPresent()) {
            logger.log("Trainer deleted, ID: " + trainerId);
            trainerRepository.delete(trainer.get());
        } else {
            throw new NoSuchElementException();
        }
    }

    private String generateNextMemberId() {
        List<Trainer> trainers = allTrainers();
        Set<String> usedIds = trainers.stream().map(Trainer::getTrainerId).collect(Collectors.toSet());

        for (int i = 1; i <= 9999; i++) {
            String candidateId = String.format("%04d", i);
            if (!usedIds.contains(candidateId)) {
                return candidateId;
            }
        }
        return null;
    }
}
