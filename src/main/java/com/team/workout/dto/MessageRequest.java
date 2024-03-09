package com.team.workout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MessageRequest {
    private String title;
    private String body;
    private String targetToken;
}