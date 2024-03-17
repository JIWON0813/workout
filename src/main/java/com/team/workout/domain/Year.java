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
public class Year {
    private int value;
    private List<Month> months;

    public Year(int year){
        this.value = year;
        this.months = new ArrayList<>();
    }

    public void addMonth(Month month){
        this.months.add(month);
    }

    public Month getMonth(Month month){
        this.months.stream().map(data -> data.getValue() == month.getValue());
        return null;
    }
}
