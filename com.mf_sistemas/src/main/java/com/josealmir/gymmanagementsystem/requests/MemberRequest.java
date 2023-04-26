package com.josealmir.gymmanagementsystem.requests;

import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import lombok.Data;

@Data
public class MemberRequest {
    private String memberId;
    private String memberShipType;
    private String startDate;
    private String endDate;
    private WorkoutPlan workoutPlan;
    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;
}
