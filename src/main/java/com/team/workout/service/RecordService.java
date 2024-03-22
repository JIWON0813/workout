package com.team.workout.service;

import com.team.workout.domain.Year;
import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.TimeStampResponse;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final UserRepository userRepository;

    public void addRecord(RecordInput record) {
        var user = userRepository.findById("1").orElseThrow(); // header

        var userRecord = user.getUserRecord();

        var id = userRecord.addRecord(record);

        userRepository.save(user);

    }

    public Map<String, Year> records(RecordInput record) {
        return null;
    }
}
