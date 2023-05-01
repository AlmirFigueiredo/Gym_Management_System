package com.josealmir.gymmanagementsystem.requests;

import java.util.List;

import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;

import lombok.Data;

@Data
public class WorkoutPlanRequest {
    private String workoutPlanId;
    private String memberId;
    private String trainerId;
    private String startDate;
    private String endDate;
    private List<DailyWorkout> dailyWorkouts;
}
