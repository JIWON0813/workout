package com.team.workout.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class UserInput {

    @NonNull private String id;

    private String token;

    private String name;

    private String email;
}