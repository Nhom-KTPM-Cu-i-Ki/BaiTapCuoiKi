package com.example.enrollment.models;


import com.example.enrollment.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Builder
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long enrollmentId;
    @Column(name = "student_id", nullable = false)
    private long studentId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "class_id", nullable = false)
    private Classzz classId;
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    @Column(name = "confirmed_date", nullable = false)
    private LocalDate confirmedDate;
    @Column(name = "credit_earned", nullable = false)
    private int creditEarned;
    @Column(name = "tuition_fee", nullable = false)
    private double tuitionFee;
    @Column(name = "notes")
    private String notes;
}
