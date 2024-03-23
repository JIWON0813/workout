package com.team.workout.controller;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.team.workout.domain.TimeStamp;
import com.team.workout.domain.Year;
import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.TimeStampResponse;
import com.team.workout.service.RecordService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RecordController implements GraphQLResolver {

    private final RecordService recordService;

    @QueryMapping
    public Map<String, Year> records(@Argument(name = "record") RecordInput record){
        return recordService.records(record);
    }

    @MutationMapping
    public void addRecord(@Argument(name = "record") RecordInput record){
        recordService.addRecord(record);
    }

}