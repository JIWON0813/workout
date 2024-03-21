package com.team.workout.domain;

import com.team.workout.dto.request.RecordInput;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TimeStamp {
    private int id;
    private boolean isFinish;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long record;

    public TimeStamp(int id, LocalDateTime startTime, LocalDateTime endTime){
        this.id = id;
        isFinish = false;
        this.startTime = startTime;
        this.endTime = endTime;

        var duration = Duration.between(startTime,endTime);
        record = duration.getSeconds();
    }

    public void update(RecordInput recordInput){
        this.isFinish = recordInput.isFinish();
        this.startTime = recordInput.getStartTime();
        this.endTime = recordInput.getEndTime();

        var duration = Duration.between(startTime,endTime);
        this.record = duration.getSeconds();
    }
}
