package com.josealmir.gymmanagementsystem.service;

import java.util.LinkedList;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.service.MemberService;
public class MemberServiceImpl implements MemberService {
    private final LinkedList<Member> members = new LinkedList<Member>();

    @Override
    public void createMember(Member member) {
        members.add(member);
    }

    @Override
    public LinkedList<Member> getAllMembers() {
        LinkedList<Member> copy = new LinkedList<Member>(members);
        return copy;
    }


}
