package com.example.authentication.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Role {
    STUDENT(0),INSTRUCTOR(1),ADMIN(2);
    private int role;

    Role(int role) {
        this.role = role;
    }
}
