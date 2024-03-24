package com.team.workout.domain;

import com.team.workout.dto.request.RecordInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "record")
public class Record {

    @Id
    private String id;
    private String userId;
    private int year;
    private int month;
    private int day;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long value;

    public Record(String userId, LocalDateTime startTime, LocalDateTime endTime, long value){
        this.year = startTime.getYear();
        this.month = startTime.getMonthValue();
        this.day = startTime.getDayOfMonth();
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.value = value;
    }
}
