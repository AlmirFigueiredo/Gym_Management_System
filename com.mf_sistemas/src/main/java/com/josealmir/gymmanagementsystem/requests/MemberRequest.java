package com.josealmir.gymmanagementsystem.requests;

import java.util.Date;

import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

import lombok.Data;

@Data
public class MemberRequest {
    private String memberId;
    private String memberShipType;
    private Date startDate;
    private Date endDate;
    private WorkoutPlan workoutPlan;
}
