package com.josealmir.gymmanagementsystem.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

public interface WorkoutPlanRepository extends MongoRepository<WorkoutPlan, ObjectId> {
    Optional<WorkoutPlan> findWorkoutPlanByMemberId(String memberId);
}
