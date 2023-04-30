package com.josealmir.gymmanagementsystem.requests;

import java.util.List;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.person.Trainer;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;

import lombok.Data;

@Data
public class WorkoutPlanRequest {
    private String workoutPlanId;
    private Member member;
    private Trainer trainer;
    private String startDate;
    private String endDate;
    private List<DailyWorkout> dailyWorkouts;
}
