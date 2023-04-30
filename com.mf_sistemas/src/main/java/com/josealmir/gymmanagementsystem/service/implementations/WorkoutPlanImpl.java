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
import com.josealmir.gymmanagementsystem.repositories.MemberRepository;
import com.josealmir.gymmanagementsystem.repositories.TrainerRepository;
import com.josealmir.gymmanagementsystem.repositories.WorkoutPlanRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.WorkoutPlanService;

@Service
public class WorkoutPlanImpl implements WorkoutPlanService {
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private MemberRepository memberRepository;

 @Override
public WorkoutPlan createWorkoutPlan(Member member, Trainer trainer, String startDate, String endDate, List<DailyWorkout> dailyWorkouts) {
    String workoutPlanId = member.getMemberId() + trainer.getTrainerId();
    WorkoutPlan workoutPlan = workoutPlanRepository.insert(new WorkoutPlan(workoutPlanId, member, trainer, startDate, endDate, dailyWorkouts));
    return workoutPlan;
}

@Override
public List<WorkoutPlan> allWorkoutPlans() {
    return workoutPlanRepository.findAll();
}

@Override
public Optional<WorkoutPlan> findWorkoutPlanByIds(String trainerId, String memberId) {
    Member member = memberRepository.findByMemberId(memberId).orElse(null);
    Trainer trainer = trainerRepository.findByTrainerId(trainerId).orElse(null);
    if (member != null && trainer != null) {
        return workoutPlanRepository.findByMemberAndTrainer(member, trainer);
    } else {
        throw new NoSuchElementException();
    }
}

@Override
public void deleteByIds(String trainerId, String memberId) {
    Member member = memberRepository.findByMemberId(memberId).orElse(null);
    Trainer trainer = trainerRepository.findByTrainerId(trainerId).orElse(null);
    if (member != null && trainer != null) {
        Optional<WorkoutPlan> workoutPlan = workoutPlanRepository.findByMemberAndTrainer(member, trainer);
        if (workoutPlan.isPresent()) {
            workoutPlanRepository.delete(workoutPlan.get());
        } else {
            throw new NoSuchElementException();
        }
    } else {
        throw new NoSuchElementException();
    }
}
}
