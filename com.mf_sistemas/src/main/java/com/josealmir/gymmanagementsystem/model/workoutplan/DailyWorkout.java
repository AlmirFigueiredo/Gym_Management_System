package com.josealmir.gymmanagementsystem.model.workoutplan;

import java.util.LinkedList;

public class DailyWorkout {
    private String dayOfWeek;
    private LinkedList<Exercise> exercises;

    public DailyWorkout() {}

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LinkedList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(LinkedList<Exercise> exercises) {
        this.exercises = exercises;
    }

    
}
