package com.team.workout.domain;

import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.TimeStampResponse;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class Day {
    private int value;
    private HashMap<Integer, List<TimeStamp>> timeStamps;


    public Day(int dayValue){
        this.value = dayValue;
        timeStamps = new HashMap<>();
    }

    public int addTimeStamp(RecordInput record){
        timeStamps.putIfAbsent(this.value, new ArrayList<>());
        var timeStampList = timeStamps.get(this.value);
        var id = timeStampList.size();

        timeStampList.add(new TimeStamp(id, record.getStartTime(), record.getEndTime()));

        return id;
    }

    public void updateTimeStamp(RecordInput record){
        var timeStampList = timeStamps.get(this.value);
        var id = record.getRecordId();

        var timeStamp = timeStampList.get(id);

        timeStamp.update(record);
    }

    public TimeStampResponse getTimeStamp(RecordInput record) {
        var timeStampList = timeStamps.get(this.value);
        var id = record.getRecordId();

        var timeStamp = timeStampList.get(id);

        return new TimeStampResponse(id, timeStamp.getRecord());
    }
}
