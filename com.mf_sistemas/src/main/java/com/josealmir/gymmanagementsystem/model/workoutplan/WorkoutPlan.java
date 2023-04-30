package com.josealmir.gymmanagementsystem.model.workoutplan;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.josealmir.gymmanagementsystem.model.person.Trainer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "workoutplans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutPlan {
    private Trainer trainer;
    private String startDate;
    private String endDate;
    @DocumentReference
    private List<DailyWorkout> dailyWorkouts;
}
