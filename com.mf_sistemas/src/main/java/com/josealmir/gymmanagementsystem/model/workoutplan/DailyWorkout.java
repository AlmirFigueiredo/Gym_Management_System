package com.josealmir.gymmanagementsystem.model.workoutplan;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "dailyWorkouts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyWorkout {
    @Id
    private String id;
    private String dayOfWeek;
    @DocumentReference
    private List<Exercise> exercises;   
    public DailyWorkout(String dayOfWeek, List<Exercise> exercises) {
        this.dayOfWeek = dayOfWeek;
        this.exercises = exercises;
    } 
}
