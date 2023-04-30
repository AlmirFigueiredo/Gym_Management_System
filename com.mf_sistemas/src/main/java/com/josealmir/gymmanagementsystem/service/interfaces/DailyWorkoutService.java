package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;

public interface DailyWorkoutService {
    DailyWorkout createDailyWorkout(String dayOfWeek, List<Exercise> exercises);
    List<DailyWorkout> allDailyWorkouts();
    Optional<DailyWorkout> dailyWorkoutByDayOfWeek(String dayOfWeek);
    void deleteDailyWorkout(String dayOfWeek);

}
