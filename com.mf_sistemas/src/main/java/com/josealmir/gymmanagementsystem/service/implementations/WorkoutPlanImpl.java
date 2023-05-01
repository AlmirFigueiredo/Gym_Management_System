package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.repositories.WorkoutPlanRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.WorkoutPlanService;

@Service
public class WorkoutPlanImpl implements WorkoutPlanService {
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Override
    public WorkoutPlan createWorkoutPlan(String memberId, String trainerId, String startDate, String endDate,
            List<DailyWorkout> dailyWorkouts) {
        String workoutPlanId = memberId+trainerId;
        WorkoutPlan workoutPlan = workoutPlanRepository
                .insert(new WorkoutPlan(workoutPlanId, memberId, trainerId, startDate, endDate, dailyWorkouts));
        return workoutPlan;
    }

    @Override
    public List<WorkoutPlan> allWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }

    @Override
    public Optional<WorkoutPlan> findWorkoutPlanByIds(String trainerId, String memberId) {
        return workoutPlanRepository.findByMemberIdAndTrainerId(memberId, trainerId);
    }

    @Override
    public void deleteByIds(String trainerId, String memberId) {
        Optional<WorkoutPlan> workoutplan = workoutPlanRepository.findByMemberIdAndTrainerId(memberId, trainerId);
        if(workoutplan.isPresent()) {
            workoutPlanRepository.delete(workoutplan.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}
