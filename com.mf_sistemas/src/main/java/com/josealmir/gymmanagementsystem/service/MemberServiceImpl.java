package com.josealmir.gymmanagementsystem.service;

import java.util.LinkedList;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.service.MemberService;
public class MemberServiceImpl implements MemberService {
    private LinkedList<Member> members = new LinkedList<Member>();

    @Override
    public void createMember(Member member) {
        members.add(member);
    }

    @Override
    public LinkedList<Member> getAllMembers() {
        LinkedList<Member> copy = new LinkedList<Member>(members);
        return copy;
    }

    @Override
    public Member findMemberById(String memberId) {
        for(Member member: this.members) {
            if(member.getId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public boolean updateMember(String memberId, Member updatedMember) {
        for(int i = 0; i < this.members.size(); i++) {
            if(this.members.get(i).getId().equals(memberId)) {
                this.members.set(i, updatedMember);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean updateWorkoutPlan(String memberId, WorkoutPlan updatePlan) {
        for(Member member : this.members) {
            if(member.getId().equals(memberId)) {
                member.setWorkoutPlan(updatePlan);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMember(String memberId) {
        for(int i = 0; i < this.members.size(); i++) {
            if(this.members.get(i).getId().equals(memberId)) {
                this.members.remove(i);
                return true;
            }
        }
        return false;
    }
}
