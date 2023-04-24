package com.josealmir.gymmanagementsystem.service.interfaces;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.josealmir.gymmanagementsystem.model.person.Member;

public interface MemberService {
    Member createMember(String memberId, String membershipType, Date startDate, Date endDate);
    List<Member> allMembers();
    Optional<Member> memberById(String memberId);
    void deleteMemberById(String memberId);
}
