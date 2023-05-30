package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.repositories.WorkoutPlanRepository;
import com.josealmir.gymmanagementsystem.requests.WorkoutPlanRequest;
import com.josealmir.gymmanagementsystem.service.interfaces.WorkoutPlanService;

@Service
public class WorkoutPlanImpl implements WorkoutPlanService {
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Override
    public WorkoutPlan createWorkoutPlan(String memberId, String trainerId, String startDate, String endDate,
            List<DailyWorkout> dailyWorkouts) {
        String id = memberId + trainerId;
        WorkoutPlan workoutPlan = workoutPlanRepository
                .insert(new WorkoutPlan(id, memberId, trainerId, startDate, endDate, dailyWorkouts));
        return workoutPlan;
    }

    @Override
    public List<WorkoutPlan> allWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }

    @Override
    public Optional<WorkoutPlan> findWorkoutPlanById(String id) {
        return workoutPlanRepository.findById(id);
    }

    @Override
    public List<WorkoutPlan> findWorkoutPlansByMemberId(String memberId) {
        return workoutPlanRepository.findAll().stream()
                .filter(workoutPlan -> memberId.equals(workoutPlan.getMemberId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WorkoutPlan> findWorkoutPlanByIds(String trainerId, String memberId) {
        return workoutPlanRepository.findByMemberIdAndTrainerId(memberId, trainerId);
    }

    @Override
    public void deleteByIds(String trainerId, String memberId) {
        Optional<WorkoutPlan> workoutplan = workoutPlanRepository.findByMemberIdAndTrainerId(memberId, trainerId);
        if (workoutplan.isPresent()) {
            workoutPlanRepository.delete(workoutplan.get());
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public WorkoutPlan updateWorkoutPlan(String id, WorkoutPlanRequest workoutPlanRequest) {
        Optional<WorkoutPlan> optionalWorkoutPlan = workoutPlanRepository.findById(id);
        if (optionalWorkoutPlan.isPresent()) {
            WorkoutPlan workoutPlan = optionalWorkoutPlan.get();
            workoutPlan.setMemberId(workoutPlanRequest.getMemberId());
            workoutPlan.setTrainerId(workoutPlanRequest.getTrainerId());
            workoutPlan.setStartDate(workoutPlanRequest.getStartDate());
            workoutPlan.setEndDate(workoutPlanRequest.getEndDate());
            workoutPlan.setDailyWorkouts(workoutPlanRequest.getDailyWorkouts());
            return workoutPlanRepository.save(workoutPlan);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deleteById(String id) {
        Optional<WorkoutPlan> workoutPlan = workoutPlanRepository.findById(id);
        if (workoutPlan.isPresent()) {
            workoutPlanRepository.delete(workoutPlan.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}
