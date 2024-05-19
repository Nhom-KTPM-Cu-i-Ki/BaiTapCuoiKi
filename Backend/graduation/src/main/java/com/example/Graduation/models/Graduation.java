package com.example.Graduation.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "graduation_applications")
@Builder
public class Graduation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicationId;
    private long studentId;
    private Date applicationDate;
    private String status;
}
