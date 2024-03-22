package com.team.workout.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TimeStamp {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long record;


}
