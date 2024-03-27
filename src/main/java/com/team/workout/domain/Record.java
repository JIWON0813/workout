package com.team.workout.domain;

import com.team.workout.dto.response.RecordResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static com.team.workout.constants.RecordConstant.MAX_SEED_STANDARD;

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

    public OffsetDateTime getStartTime(){
        return startTime.atOffset(ZoneOffset.UTC);
    }

    public OffsetDateTime getEndTime(){
        return endTime.atOffset(ZoneOffset.UTC);
    }
}
