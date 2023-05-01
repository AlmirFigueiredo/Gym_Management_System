package com.josealmir.gymmanagementsystem.model.workoutplan;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "workoutplans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutPlan {
    @Id
    private String Id;
    private String memberId;
    private String trainerId;
    private String startDate;
    private String endDate;
    @DocumentReference
    private List<DailyWorkout> dailyWorkouts;
}
