package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

public interface MemberService {
    Member createMember(String memberId, String membershipType, Date startDate, Date endDate, WorkoutPlan workoutPlan);
    List<Member> allMembers();
    Optional<Member> memberById(String memberId);
    void deleteByMemberId(String memberId);
}
