package com.josealmir.gymmanagementsystem.service.interfaces;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

public interface MemberService {
    Member createMember(String fullName, String email, String address, String phoneNumber, String memberId,
    String memberShipType, String startDate, String endDate, WorkoutPlan workoutPlan);
    List<Member> allMembers();
    Optional<Member> memberById(String memberId);
    Member updateByMemberId(String memberId, Member updatedMember) throws NoSuchElementException;
    void deleteByMemberId(String memberId);
}
