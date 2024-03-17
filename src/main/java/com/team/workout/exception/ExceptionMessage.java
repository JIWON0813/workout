package com.team.workout.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionMessage {
    ILLEGAL_ARGUMENT("유효하지않은 값입니다.");

    private final String message;
}