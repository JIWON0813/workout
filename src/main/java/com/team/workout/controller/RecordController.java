package com.team.workout.controller;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.team.workout.domain.TimeStamp;
import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.TimeStampResponse;
import com.team.workout.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RecordController implements GraphQLResolver {

    private final RecordService recordService;

    @QueryMapping
    public TimeStampResponse getRecord(@Argument(name = "record") RecordInput record){
        return recordService.getRecord(record);
    }

    @QueryMapping
    public int getSeedStandard(){
        return 10;
    }

    @MutationMapping
    public int addRecord(@Argument(name = "record") RecordInput record){
        return recordService.addRecord(record);
    }

    @MutationMapping
    public void updateRecord(@Argument(name = "record") RecordInput record){
        recordService.updateRecord(record);
    }
}