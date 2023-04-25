package com.josealmir.gymmanagementsystem.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.requests.MemberRequest;
import com.josealmir.gymmanagementsystem.service.interfaces.MemberService;

@RestController
@RequestMapping("/Members")
public class MemberController {
    @Autowired
    private MemberService memberService;    
    
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return new ResponseEntity<List<Member>>(memberService.allMembers(), HttpStatus.OK);
    }
    @PostMapping
    public Member createMember(@RequestBody MemberRequest memberRequest) {
        String memberId = memberRequest.getMemberId();
        String membershipType = memberRequest.getMembershipType();
        Date startDate = memberRequest.getStartDate();
        Date endDate = memberRequest.getEndDate();
        WorkoutPlan workoutPlan = memberRequest.getWorkoutPlan();
        return memberService.createMember(memberId, membershipType, startDate, endDate, workoutPlan);
    }
    @GetMapping("/{memberId}")
    public ResponseEntity<Optional<Member>> getMemberById(@PathVariable String memberId) {
        return new ResponseEntity<Optional<Member>>(memberService.memberById(memberId), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable String memberId) {
        memberService.deleteMemberById(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
