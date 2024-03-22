package com.team.workout.domain;

import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.TimeStampResponse;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class UserRecord {
    private HashMap<Integer, Year> years;

    public UserRecord() {
        this.years = new HashMap<>();
    }

    public int addRecord(RecordInput record){
        years.putIfAbsent(record.getRecordYear(), new Year(record.getRecordYear()));

        var year = years.get(record.getRecordYear());

        return year.addTimeStamp(record);
    }

}
