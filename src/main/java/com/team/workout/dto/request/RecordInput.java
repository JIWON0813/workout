package com.team.workout.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordInput {
    private int recordId;

    @NotNull(message = "시작 일자는 필수 입력 값 입니다")
    private LocalDateTime startTime;

    @NotNull(message = "종료 일자는 필수 입력 값 입니다")
    private LocalDateTime endTime;

    private int recordYear;
    private int recordMonth;
    private int recordDay;

    public RecordInput(int recordId, LocalDateTime startTime, LocalDateTime endTime){
        this.recordId = recordId;
        this.startTime = startTime;
        this.endTime = endTime;

        recordYear = startTime.getYear();
        recordMonth = startTime.getMonth().getValue();
        recordDay = startTime.getDayOfMonth();
    }
}