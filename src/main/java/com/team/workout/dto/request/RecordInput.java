package com.team.workout.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordInput {

    @NotNull(message = "userId는 필수입력값 입니다")
    private String userId;

    private int recordId;

    private boolean isFinish;

    @NotNull(message = "시작 일자는 필수 입력 값 입니다")
    private LocalDateTime startTime;

    @NotNull(message = "종료 일자는 필수 입력 값 입니다")
    private LocalDateTime endTime;

    private int recordYear;
    private int recordMonth;
    private int recordDay;

    public RecordInput(String userId, int recordId, boolean isFinish, LocalDateTime startTime, LocalDateTime endTime){
        this.userId = userId;
        this.recordId = recordId;
        this.isFinish = isFinish;
        this.startTime = startTime;
        this.endTime = endTime;

        recordYear = startTime.getYear();
        recordMonth = startTime.getMonth().getValue();
        recordDay = startTime.getDayOfMonth();
    }
}