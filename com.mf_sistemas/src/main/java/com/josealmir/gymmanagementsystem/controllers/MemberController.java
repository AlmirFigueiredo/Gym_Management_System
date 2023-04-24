package com.josealmir.gymmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.model.person.Member;

@RestController
@RequestMapping("/Members")
public class MemberController {
    @Autowired
    private Member member;
    
    @GetMapping
    public 
}
