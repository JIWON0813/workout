package com.team.workout.domain;

import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.TimeStampResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Month {
    private int value;
    private HashMap<Integer, Day> days;

    public Month(int month){
        this.value = month;
        this.days = new HashMap<>();
    }

    public int addTimeStamp(RecordInput record){
        days.putIfAbsent(record.getRecordMonth(), new Day(record.getRecordDay()));

        var day = days.get(record.getRecordDay());

        return day.addTimeStamp(record);
    }

    public void updateTimeStamp(RecordInput record){
        var day = days.get(record.getRecordDay());

        day.updateTimeStamp(record);
    }

    public TimeStampResponse getTimeStamp(RecordInput record) {
        var day = days.get(record.getRecordDay());

        return day.getTimeStamp(record);
    }
}
