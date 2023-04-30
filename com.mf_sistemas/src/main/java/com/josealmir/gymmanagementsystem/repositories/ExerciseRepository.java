package com.josealmir.gymmanagementsystem.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, ObjectId> {
    
}
