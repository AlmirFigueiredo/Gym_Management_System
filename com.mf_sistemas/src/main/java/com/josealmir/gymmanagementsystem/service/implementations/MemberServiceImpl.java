package com.josealmir.gymmanagementsystem.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.josealmir.gymmanagementsystem.model.person.Member;
import com.josealmir.gymmanagementsystem.model.workoutplan.WorkoutPlan;
import com.josealmir.gymmanagementsystem.repositories.MemberRepository;
import com.josealmir.gymmanagementsystem.service.interfaces.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public Member createMember(String fullName, String email, String address, String phoneNumber,
    String memberShipType, String startDate, String endDate, WorkoutPlan workoutPlan) {
        String memberId = generateNextMemberId();
        if(memberId != null) {
            Member member = memberRepository.insert(new Member(fullName, email, address, phoneNumber, memberId, memberShipType, startDate, endDate, workoutPlan));
            return member;
        } else {
            throw new IllegalStateException("Member limit reached. Cannot create more members.");
        }
    }
    @Override
    public List<Member> allMembers() {
        return memberRepository.findAll();
    }
    @Override
    public Optional<Member> memberById(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }
    @Override
    public Member updateByMemberId(String memberId, Member updatedMember) {
        Optional<Member> member = memberRepository.findByMemberId(memberId);
        if(!member.isPresent()) {
            throw new NoSuchElementException();
        }
        Member currentMember = member.get();
        currentMember.setAddress(updatedMember.getAddress());
        currentMember.setEmail(updatedMember.getEmail());
        currentMember.setFullName(updatedMember.getFullName());
        currentMember.setMemberShipType(updatedMember.getMemberShipType());
        currentMember.setPhoneNumber(updatedMember.getPhoneNumber());
        currentMember.setStartDate(updatedMember.getStartDate());
        currentMember.setEndDate(updatedMember.getEndDate());
        currentMember.setWorkoutPlan(updatedMember.getWorkoutPlan());
        return memberRepository.save(currentMember);
    }

    @Override
    public void deleteByMemberId(String memberId) {
        Optional<Member> member = memberRepository.findByMemberId(memberId);
        if(member.isPresent()) {
            memberRepository.delete(member.get());
        } else {
            throw new NoSuchElementException();
        }
    }
    private String generateNextMemberId() {
        List<Member> members = allMembers();
        Set<String> usedIds = members.stream().map(Member::getMemberId).collect(Collectors.toSet());
    
        for (int i = 1; i <= 9999; i++) {
            String candidateId = String.format("%04d", i);
            if (!usedIds.contains(candidateId)) {
                return candidateId;
            }
        }
        return null;
    }
}
