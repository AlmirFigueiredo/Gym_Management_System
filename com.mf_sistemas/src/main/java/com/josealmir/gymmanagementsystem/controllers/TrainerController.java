package com.josealmir.gymmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josealmir.gymmanagementsystem.service.interfaces.TrainerService;

@RestController
@RequestMapping("/Trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;
}
