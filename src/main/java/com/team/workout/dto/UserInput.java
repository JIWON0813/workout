package com.team.workout.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
@AllArgsConstructor
@Data
public class UserInput {

    @NotNull(message = "id는 필수입력값 입니다")
    private String id;

    private String token;

    private String name;

    private String email;

    private boolean isQuit = false;
}