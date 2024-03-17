package com.team.workout.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Month {
    private int value;
    private List<Day> days;

    public Month(int month){
        this.value = month;
        this.days = new ArrayList<>();
    }


    public void addDay(Day day){
        this.days.add(day);
    }
}
