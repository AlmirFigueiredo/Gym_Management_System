package com.josealmir.gymmanagementsystem.model.booking;

import com.josealmir.gymmanagementsystem.model.groupfitclasses.GroupFitClass;
import com.josealmir.gymmanagementsystem.model.person.Member;

public class ClassReservation {
    private Member member;
    private GroupFitClass fitClass;
    
    public ClassReservation() {}

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public GroupFitClass getFitClass() {
        return fitClass;
    }

    public void setFitClass(GroupFitClass fitClass) {
        this.fitClass = fitClass;
    }

    
}
