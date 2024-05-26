package com.example.enrollment.dto;

import com.example.enrollment.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EnrollmentDTO {
    private Long enrollmentId;
    private Long studentId;
    private Long classId;
    private LocalDate registrationDate;
    private Status status;
    private LocalDate confirmedDate;
    private Integer creditEarned;
    private Double tuitionFee;
    private String notes;
}
