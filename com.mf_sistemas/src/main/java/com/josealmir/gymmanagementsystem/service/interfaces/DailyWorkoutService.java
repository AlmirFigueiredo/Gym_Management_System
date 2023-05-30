package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.josealmir.gymmanagementsystem.model.workoutplan.DailyWorkout;
import com.josealmir.gymmanagementsystem.model.workoutplan.Exercise;
import com.josealmir.gymmanagementsystem.requests.DailyWorkoutRequest;

public interface DailyWorkoutService {
    DailyWorkout createDailyWorkout(String dayOfWeek, List<Exercise> exercises);
    List<DailyWorkout> allDailyWorkouts();
    Optional<DailyWorkout> dailyWorkoutById(String id);
    Optional<DailyWorkout> dailyWorkoutByDayOfWeek(String dayOfWeek);
    DailyWorkout updateDailyWorkout(String id, DailyWorkoutRequest dailyWorkoutRequest);
    void deleteDailyWorkout(String id);
}
