package com.josealmir.gymmanagementsystem.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

@Repository
public interface WorkoutPlanRepository extends MongoRepository<WorkoutPlan, ObjectId> {
    
}
