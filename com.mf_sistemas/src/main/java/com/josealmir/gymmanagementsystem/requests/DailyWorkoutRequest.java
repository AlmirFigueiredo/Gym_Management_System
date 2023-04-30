package com.josealmir.gymmanagementsystem.requests;

import java.util.List;

import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;

import lombok.Data;

@Data
public class DailyWorkoutRequest {
    private String dayOfWeek;
    private List<Exercise> exercises;
}
