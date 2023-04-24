package com.josealmir.gymmanagementsystem.requests;

import lombok.Data;

@Data
public class TrainerRequest {
    private String trainerId;
    private String speciality;
    private Double salary;
    private String certificationNumber;
}
