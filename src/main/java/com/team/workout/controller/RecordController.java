package com.team.workout.controller;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.team.workout.domain.Record;
import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.RecordResponse;
import com.team.workout.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RecordController implements GraphQLResolver {

    private final RecordService recordService;

    @QueryMapping
    public List<Record> records(){
        var result = recordService.records();
        return result;
    }

    @QueryMapping
    public long seeds(@Argument(name = "date") LocalDate localDate){
        var result = recordService.seeds(localDate);
        return result;
    }

    @MutationMapping
    public void deleteRecordsByDay(@Argument(name = "date") LocalDate localDate){
        recordService.deleteRecordsByDay(localDate);
    }

    @QueryMapping
    public List<Record> recordsByDay(@Argument(name = "date") LocalDate localDate){
        return recordService.recordsByDay(localDate);
    }

    @MutationMapping
    public RecordResponse addRecord(@Argument(name = "record") RecordInput record){
        return recordService.addRecord(record);
    }

}