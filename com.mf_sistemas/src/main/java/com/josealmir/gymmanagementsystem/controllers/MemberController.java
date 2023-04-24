package com.josealmir.gymmanagementsystem.controllers;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.requests.MemberRequest;
import com.josealmir.gymmanagementsystem.service.interfaces.MemberService;

@RestController
@RequestMapping("/Members")
public class MemberController {
    @Autowired
    private MemberService memberService;    
    
    @PostMapping
    public Member createMember(@RequestBody MemberRequest memberRequest) {
        String memberId = memberRequest.getMemberId();
        String membershipType = memberRequest.getMembershipType();
        Date startDate = memberRequest.getStartDate();
        Date endDate = memberRequest.getEndDate();
        return memberService.createMember(memberId, membershipType, startDate, endDate);
    }
}
