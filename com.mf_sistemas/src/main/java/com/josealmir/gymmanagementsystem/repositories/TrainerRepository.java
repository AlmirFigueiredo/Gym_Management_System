package com.josealmir.gymmanagementsystem.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.josealmir.gymmanagementsystem.model.person.Trainer;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, ObjectId>{
    Optional<Trainer> findTrainerById(String trainerId);
}
