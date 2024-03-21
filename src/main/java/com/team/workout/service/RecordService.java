package com.team.workout.service;

import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.TimeStampResponse;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final UserRepository userRepository;

    public int addRecord(RecordInput record) {
        var user = userRepository.findById(record.getUserId()).orElseThrow();

        var userRecord = user.getUserRecord();

        var id = userRecord.addRecord(record);

        userRepository.save(user);

        return id;
    }

    public void updateRecord(RecordInput record){
        var user = userRepository.findById(record.getUserId()).orElseThrow();

        var userRecord = user.getUserRecord();

        userRecord.updateRecord(record);

        userRepository.save(user);
    }

    public TimeStampResponse getRecord(RecordInput record) {
        var user = userRepository.findById(record.getUserId()).orElseThrow();

        var userRecord = user.getUserRecord();

        return userRecord.getRecord(record);
    }
}
