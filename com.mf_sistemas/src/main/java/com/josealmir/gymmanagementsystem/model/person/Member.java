package com.josealmir.gymmanagementsystem.model.person;

import java.util.Date;

import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

public class Member extends Person {

    private String memberId;
    private String memberShipType;
    private WorkoutPlan workoutPlan;
    private Date startDate;
    private Date endDate;

    public Member(){}

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberShipType() {
        return memberShipType;
    }

    public void setMemberShipType(String memberShipType) {
        this.memberShipType = memberShipType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
