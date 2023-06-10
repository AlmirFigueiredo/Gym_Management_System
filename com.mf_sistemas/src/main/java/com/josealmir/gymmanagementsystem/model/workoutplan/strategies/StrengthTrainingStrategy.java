package com.josealmir.gymmanagementsystem.model.workoutplan.strategies;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;

public class StrengthTrainingStrategy implements WorkoutStrategy {

    @Override
    public List<DailyWorkout> generateRoutine() {
        
        Exercise squat = new Exercise("Squat", 4, 8, 90);
        Exercise deadlift = new Exercise("Deadlift", 3, 6, 120);
        Exercise benchPress = new Exercise("Bench Press", 4, 8, 90);
        Exercise shoulderPress = new Exercise("Shoulder Press", 3, 10, 60);
        Exercise pullUp = new Exercise("Pull Up", 3, 10, 60);
        Exercise bentOverRow = new Exercise("Bent Over Row", 4, 8, 90);
        
        
        DailyWorkout monday = new DailyWorkout("Monday", Arrays.asList(squat, benchPress));
        DailyWorkout wednesday = new DailyWorkout("Wednesday", Arrays.asList(deadlift, pullUp));
        DailyWorkout friday = new DailyWorkout("Friday", Arrays.asList(shoulderPress, bentOverRow));
        
        
        List<DailyWorkout> weeklyRoutine = new ArrayList<>();
        weeklyRoutine.add(monday);
        weeklyRoutine.add(wednesday);
        weeklyRoutine.add(friday);
        
        return weeklyRoutine;
    }
}
