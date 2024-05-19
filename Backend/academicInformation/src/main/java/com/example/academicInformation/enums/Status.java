package com.example.academicInformation.enums;

import lombok.Getter;

@Getter
public enum Status {
    NON_GRADUATED(0),GRADUATED(1);
    private int status;

    Status(int status) {
        this.status = status;
    }
}
