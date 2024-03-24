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

    private static final BigDecimal MINUTE = new BigDecimal(10);

    public Character(String name){
        this.name = name;
        level = 0;
        exp = new BigDecimal(0);
    }

    public void addExp(long record){
        var tempBigDecimal = new BigDecimal(record);
        var standard = this.getStandardByLevel(this.level);
        var result = standard.subtract(tempBigDecimal);

        updateLevel(result);
    }

    public double getExp(){
        return exp.divide(this.getStandardByLevel(this.level)).doubleValue();
    }

    private void updateLevel(BigDecimal result) {
        BigDecimal standard = new BigDecimal(0);

        while(result.intValue() <= 0){
            level++;
            standard = this.getStandardByLevel(this.level);
            result = result.add(standard);
        }

        this.exp = exp.add(standard).subtract(result);

        if(exp.intValue() >= standard.intValue()){
            level++;
            exp.subtract(standard);
        }
    }

    public BigDecimal getStandardByLevel(int level){
        if(level == 0){
            return new BigDecimal(600);
        }
        return new BigDecimal(6000 * level);
    }
}
