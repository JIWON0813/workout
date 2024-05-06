package com.team.workout.domain;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.team.workout.constants.RecordConstant.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    @Size(max = 9, message = "8자를 초과할 수 없습니다.")
    private String name;
    private int level;
    private long exp;

    public Character(String name){
        this.name = name;
        level = 0;
        exp = 0;
    }

    public void addExp(long seeds){
        var standard = this.getStandardByLevel(this.level);
        var result = standard - seeds;

        updateLevel(result);
    }

    public double getExp(){
        var standard = this.getStandardByLevel(this.level);
        return new BigDecimal(this.exp).divide(BigDecimal.valueOf(standard), 3, RoundingMode.HALF_UP).doubleValue();
    }

    private void updateLevel(long result) {
        var standard = this.getStandardByLevel(this.level);

        while(result <= 0){
            level++;
            standard = this.getStandardByLevel(this.level);
            result = result + standard;
        }

        this.exp = exp + standard - result;

        if(exp >= standard){
            level++;
            this.exp -= standard;
        }
    }

    public double growthRateByDay(long seeds){
        var standard = this.getStandardByLevel(this.level);
        long beforeSeedExp = this.exp - seeds;

        if(beforeSeedExp < 0){
            standard = this.getStandardByLevel(this.level-1);
        }

        return new BigDecimal(seeds).divide(BigDecimal.valueOf(standard), 3, RoundingMode.HALF_UP).doubleValue();
    }

    public long getStandardByLevel(int level){
        if(level == 0){
            return 1;
        }

        return 10 * level; // 변경
    }
}
