package com.team.workout.domain;

import com.team.workout.dto.RecordInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String token;

    private String name;

    private String email;

    private boolean isQuit;

    private Character character;

    private List<Year> years = new ArrayList<>();

    public void addRecord(RecordInput record){
        Year year = years.stream().filter(data -> data.getValue() == record.getRecordYear()).findFirst().orElse(null);
        if(year == null){
            year = new Year(record.getRecordYear());
            years.add(year);
        }

        var months = year.getMonths();

        Month month = months.stream().filter(data -> data.getValue() == record.getRecordMonth()).findFirst().orElse(null);

        if(month == null){
            month = new Month(record.getRecordMonth());
            months.add(month);
        }

        month.addDay(new Day(record.getStartTime(),record.getEndTime()));
    }
    public void quit(){
        isQuit = true;
    }

}
