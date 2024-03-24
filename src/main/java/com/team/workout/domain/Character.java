package com.team.workout.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    private String name;
    private int level;
    private BigDecimal exp;

    private static final BigDecimal TEN = new BigDecimal(10);
    private static final BigDecimal MINUTE = new BigDecimal(10);
    private static final BigDecimal HUNDRED = new BigDecimal(10);

    public Character(String name){
        this.name = name;
        level = 0;
        exp = new BigDecimal(0);
    }

    public void addExp(long record){
        var tempBigDecimal = new BigDecimal(record);
        tempBigDecimal = tempBigDecimal.divide(MINUTE);
        tempBigDecimal = tempBigDecimal.divide(TEN);
        exp = exp.add(tempBigDecimal);
        if(exp.doubleValue() >= 100){
            exp = exp.divide(HUNDRED);
            level++;
        }
    }

    public double getExp(){
        return exp.doubleValue();
    }
}
