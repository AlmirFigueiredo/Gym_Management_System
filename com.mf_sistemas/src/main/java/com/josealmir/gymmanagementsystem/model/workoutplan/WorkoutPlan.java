package com.josealmir.gymmanagementsystem.model.workoutplan;

import java.time.LocalDate;
import java.util.LinkedList;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.person.Trainer;

public class WorkoutPlan {
    private Trainer trainer;
    private LocalDate starDate;
    private LocalDate endDate;
    private LinkedList<DailyWorkout> dailyWorkouts;

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

    public LinkedList<DailyWorkout> getDailyWorkouts() {
        return dailyWorkouts;
    }

    public void setDailyWorkouts(LinkedList<DailyWorkout> dailyWorkouts) {
        this.dailyWorkouts = dailyWorkouts;
    }

    

}
