package com.josealmir.gymmanagementsystem.requests;

import java.sql.Date;
import java.util.List;

import com.josealmir.gymmanagementsystem.model.person.Trainer;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;

import lombok.Data;

@Data
public class WorkoutPlanRequest {
    private Trainer trainer;
    private Date starDate;
    private Date endDate;
    private List<DailyWorkout> dailyWorkouts;
}
