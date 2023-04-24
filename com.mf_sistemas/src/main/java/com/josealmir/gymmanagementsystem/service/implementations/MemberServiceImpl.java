package com.josealmir.gymmanagementsystem.service.implementations;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.repositories.MemberRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Member createMember(String memberId, String membershipType, Date startDate, Date endDate) {
        Member member = memberRepository.insert(new Member(memberId, membershipType, startDate, endDate));
        return member;
    }
}
