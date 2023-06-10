package com.josealmir.gymmanagementsystem.model.workoutplan;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.josealmir.gymmanagementsystem.model.workoutplan.strategies.WorkoutStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "workoutplans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutPlan {
    @Id
    private String id;
    private String memberId;
    private String trainerId;
    private String startDate;
    private String endDate;
    @DocumentReference
    private List<DailyWorkout> dailyWorkouts;
    private WorkoutStrategy workoutStrategy;

    public WorkoutPlan(String id, String memberId, String trainerId, String startDate, String endDate, List<DailyWorkout> dailyWorkouts) {
        this.id = id;
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyWorkouts = dailyWorkouts;
    }

    public void generateRoutine() {
        this.dailyWorkouts = workoutStrategy.generateRoutine();
    }
}
