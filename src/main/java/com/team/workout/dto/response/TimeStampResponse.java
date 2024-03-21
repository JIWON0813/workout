package com.team.workout.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class TimeStampResponse {
    private int id;
    private long record;
    private long seed;

    public TimeStampResponse(int id, long record){
        this.id = id;
        this.record = record;
        this.seed = record / 60 / 10;
    }
}
