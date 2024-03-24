package com.team.workout.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RecordInput {
    @NotNull(message = "시작 일자는 필수 입력 값 입니다")
    private LocalDateTime startTime;

    @NotNull(message = "종료 일자는 필수 입력 값 입니다")
    private LocalDateTime endTime;

    @NotNull(message = "기록 값은 필수 입력 값 입니다.")
    private long record;
}