package com.josealmir.gymmanagementsystem.service.implementations;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.repositories.MemberRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public Member createMember(String memberId, String membershipType, Date startDate, Date endDate) {
        Member member = memberRepository.insert(new Member(memberId, membershipType, startDate, endDate));
        return member;
    }
    @Override
    public List<Member> allMembers() {
        return memberRepository.findAll();
    }
    @Override
    public Optional<Member> memberById(String memberId) {
        return memberRepository.findMemberById(memberId);
    }
}
