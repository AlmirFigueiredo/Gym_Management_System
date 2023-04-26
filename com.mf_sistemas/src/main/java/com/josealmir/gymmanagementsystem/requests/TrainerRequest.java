package com.josealmir.gymmanagementsystem.requests;

import lombok.Data;

@Data
public class TrainerRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String trainerId;
    private String speciality;
    private Double salary;
    private String certificationNumber;
}
