package com.example.enrollment.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    PENDING(0),APPROVED(1);
    private int status;
}
