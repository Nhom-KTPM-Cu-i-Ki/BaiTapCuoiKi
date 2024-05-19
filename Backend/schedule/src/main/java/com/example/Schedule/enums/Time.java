package com.example.Schedule.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Time {
    T1_3(0),T4_6(1),T7_9(2),T10_12(3),T13_15(4);
    private int time;
}
