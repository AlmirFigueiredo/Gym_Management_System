package com.josealmir.gymmanagementsystem.model.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "trainers")
@Data
@EqualsAndHashCode(callSuper =  true)
@NoArgsConstructor
@AllArgsConstructor
public class Trainer extends Person {
    @Id
    private String trainerId;
    private String speciality;
    private Double salary;
    private String certificationNumber;
}
