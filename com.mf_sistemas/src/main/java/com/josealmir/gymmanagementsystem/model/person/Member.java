package com.josealmir.gymmanagementsystem.model.person;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "members")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Member extends Person {
    @Id
    private String memberId;
    private String memberShipType;
    private Date startDate;
    private Date endDate;
    @DocumentReference
    private WorkoutPlan workoutPlan;    
}
