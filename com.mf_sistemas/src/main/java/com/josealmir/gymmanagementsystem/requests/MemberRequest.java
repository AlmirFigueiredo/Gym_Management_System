package com.josealmir.gymmanagementsystem.requests;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberRequest {
    private String memberId;
    private String membershipType;
    private Date startDate;
    private Date endDate;
}
