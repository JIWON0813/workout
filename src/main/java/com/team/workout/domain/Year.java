package com.team.workout.domain;

import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.TimeStampResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Getter
@NoArgsConstructor
public class Year {
    private int value;
    private HashMap<Integer, Month> months;

    public Year(int year){
        this.value = year;
        this.months = new HashMap<>();
    }

    public int addTimeStamp(RecordInput record){
        months.putIfAbsent(record.getRecordMonth(), new Month(record.getRecordMonth()));

        var month = months.get(record.getRecordMonth());

        return month.addTimeStamp(record);
    }

    public void updateTimeStamp(RecordInput record){
        var month = months.get(record.getRecordMonth());

        month.updateTimeStamp(record);
    }

    public TimeStampResponse getTimeStamp(RecordInput record) {
        var month = months.get(record.getRecordMonth());

        return month.getTimeStamp(record);
    }
}
