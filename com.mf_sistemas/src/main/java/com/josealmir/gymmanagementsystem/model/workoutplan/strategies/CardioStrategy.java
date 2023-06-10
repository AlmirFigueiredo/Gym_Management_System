package com.josealmir.gymmanagementsystem.model.workoutplan.strategies;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;

public class CardioStrategy implements WorkoutStrategy {

    @Override
    public List<DailyWorkout> generateRoutine() {
        Exercise running = new Exercise("Running", 1, 1, 1800); // 30 minutos
        Exercise cycling = new Exercise("Cycling", 1, 1, 2400); // 40 minutos
        Exercise swimming = new Exercise("Swimming", 1, 1, 1500); // 25 minutos
        Exercise jumpRope = new Exercise("Jump Rope", 10, 1, 60); // 10 sets of 1 min
        Exercise rowing = new Exercise("Rowing", 1, 1, 1800); // 30 minutos
        
        DailyWorkout monday = new DailyWorkout("Monday", Arrays.asList(running));
        DailyWorkout wednesday = new DailyWorkout("Wednesday", Arrays.asList(cycling, jumpRope));
        DailyWorkout friday = new DailyWorkout("Friday", Arrays.asList(swimming, rowing));
        
        List<DailyWorkout> weeklyRoutine = new ArrayList<>();
        weeklyRoutine.add(monday);
        weeklyRoutine.add(wednesday);
        weeklyRoutine.add(friday);
        
        return weeklyRoutine;
    }
}
