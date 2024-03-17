package com.team.workout.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RecordInput {

    @NotNull(message = "id는 필수입력값 입니다")
    private String id;

    @NotNull(message = "시작 일자는 필수 입력 값 입니다")
    private LocalDateTime startTime;

    @NotNull(message = "종료 일자는 필수 입력 값 입니다")
    private LocalDateTime endTime;

    private int recordYear;
    private int recordMonth;
    private int recordDay;

    public RecordInput(String id, LocalDateTime startTime, LocalDateTime endTime){
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;

        recordYear = startTime.getYear();
        recordMonth = startTime.getMonth().getValue();
        recordDay = startTime.getDayOfMonth();
    }
}