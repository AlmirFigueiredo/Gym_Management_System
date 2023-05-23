package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.requests.MemberRequest;

public interface MemberService {
    Member createMember(String fullName, String email, String address, String phoneNumber,
    String memberShipType, String startDate, String endDate, WorkoutPlan workoutPlan);
    List<Member> allMembers();
    Optional<Member> memberById(String memberId);
    Member updateMember(String memberId, MemberRequest memberRequest);
    void deleteByMemberId(String memberId);
}
