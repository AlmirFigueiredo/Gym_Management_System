package com.josealmir.gymmanagementsystem.model.workoutplan;

import java.time.LocalDate;
import java.util.List;

import com.josealmir.gymmanagementsystem.model.person.Trainer;

public class WorkoutPlan {
    private Trainer trainer;
    private LocalDate starDate;
    private LocalDate endDate;
    private List<DailyWorkout> dailyWorkouts;

    public WorkoutPlan() {}

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<DailyWorkout> getDailyWorkouts() {
        return dailyWorkouts;
    }

    public void setDailyWorkouts(List<DailyWorkout> dailyWorkouts) {
        this.dailyWorkouts = dailyWorkouts;
    }
}
