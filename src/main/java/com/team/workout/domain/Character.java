package com.team.workout.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Character {
    private String name;
    private int level;
    private double exp;

    public Character(String name){
        this.name = name;
        level = 0;
        exp = 0.0;
    }
}
