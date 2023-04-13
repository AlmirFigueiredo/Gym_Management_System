package com.josealmir.gymmanagementsystem.service;

import java.util.LinkedList;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;

public interface MemberService {
    Member createMember(Member member);
    Member findMemberById(String memberId);
    LinkedList<Member> getAllMembers();
    Member updateMember(String memberId, Member updatedMember);
    WorkoutPlan updateWorkoutPlan(String memberId, WorkoutPlan updatePlan);
    void deleteMember(String memberId);
}
