package com.team.workout.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Day {
    private int value;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String record;

    public Day(LocalDateTime startTime, LocalDateTime endTime){
        this.value = startTime.getDayOfMonth();
        this.startTime = startTime;
        this.endTime = endTime;

        var duration = Duration.between(startTime,endTime);
        this.record = MessageFormat.format("{0}:{1}:{2}",duration.toHours(), duration.toMinutes(), duration.toSecondsPart());
    }
}
