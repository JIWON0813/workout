package com.team.workout.domain;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    @Size(max = 9, message = "8자를 초과할 수 없습니다.")
    private String name;
    private int level;
    private BigDecimal exp;

    public Character(String name){
        this.name = name;
        level = 0;
        exp = new BigDecimal(0);
    }

    public void addExp(long record){
        var recordBigDecimal = new BigDecimal(record);
        var standard = this.getStandardByLevel(this.level);
        var result = standard.subtract(recordBigDecimal);

        updateLevel(result);
    }

    public double getExp(){
        var standard = this.getStandardByLevel(this.level);
        return this.exp.divide(standard, 3, RoundingMode.HALF_UP).doubleValue();
    }

    private void updateLevel(BigDecimal result) {
        BigDecimal standard = this.getStandardByLevel(this.level);

        while(result.intValue() <= 0){
            level++;
            standard = this.getStandardByLevel(this.level);
            result = result.add(standard);
        }

        this.exp = exp.add(standard).subtract(result);

        if(exp.intValue() >= standard.intValue()){
            level++;
            this.exp = exp.subtract(standard);
        }
    }

    public BigDecimal getStandardByLevel(int level){
        if(level == 0){
            return new BigDecimal(600);
        }

        return new BigDecimal(6000 * level);
    }
}
