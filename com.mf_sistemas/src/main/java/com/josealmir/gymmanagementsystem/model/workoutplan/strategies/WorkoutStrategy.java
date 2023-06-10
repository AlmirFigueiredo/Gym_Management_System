package com.josealmir.gymmanagementsystem.model.workoutplan.strategies;

import java.util.List;
import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;

public interface WorkoutStrategy {
    List<DailyWorkout> generateRoutine();
}
