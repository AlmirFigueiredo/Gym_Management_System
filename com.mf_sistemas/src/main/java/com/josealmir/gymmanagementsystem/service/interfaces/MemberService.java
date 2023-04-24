package com.josealmir.gymmanagementsystem.service.interfaces;

import java.sql.Date;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

public interface MemberService {
    Member createMember(String memberId, String membershipType, Date startDate, Date endDate);

}
