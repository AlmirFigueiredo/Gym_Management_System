package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.person.Trainer;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.repositories.WorkoutPlanRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.WorkoutPlanService;

@Service
public class WorkoutPlanImpl implements WorkoutPlanService {
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;
    @Override
    public WorkoutPlan createWorkoutPlan(Member member, Trainer trainer, String startDate, String endDate, List<DailyWorkout> dailyWorkouts) {
        WorkoutPlan workoutPlan = workoutPlanRepository.insert(new WorkoutPlan(member, trainer, startDate, endDate, dailyWorkouts));
        return workoutPlan;
    }
    @Override
    public List<WorkoutPlan> allWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }
    @Override
    public Optional<WorkoutPlan> findWorkoutPlanByIds(String trainerId, String memberId) {
        return workoutPlanRepository.findWorkoutPlanBIds(memberId, trainerId);
    }
    @Override
    public void deleteByIds(String trainerId, String memberId) {
        Optional<WorkoutPlan> workoutPlan = workoutPlanRepository.findWorkoutPlanBIds(memberId, trainerId);
        if(workoutPlan.isEmpty()) {
            workoutPlanRepository.delete(workoutPlan.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}
