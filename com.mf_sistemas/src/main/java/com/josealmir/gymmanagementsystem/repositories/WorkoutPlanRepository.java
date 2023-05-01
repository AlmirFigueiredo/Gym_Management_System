package com.josealmir.gymmanagementsystem.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

@Repository
public interface WorkoutPlanRepository extends MongoRepository<WorkoutPlan, ObjectId> {
    Optional<WorkoutPlan> findByIds(String memberId, String trainerId);
}
