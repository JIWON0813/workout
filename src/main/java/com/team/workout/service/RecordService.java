package com.team.workout.service;

import com.team.workout.config.HeaderConfig;
import com.team.workout.domain.Record;
import com.team.workout.dto.request.RecordInput;
import com.team.workout.repository.RecordRepository;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final UserRepository userRepository;
    private final RecordRepository recordRepository;
    private final HeaderConfig headerConfig;

    public List<Record> records(){
        return recordRepository.findAllByUserId(headerConfig.getId());
    }

    public String addRecord(RecordInput recordInput) {
        var record = recordRepository.save(new Record(headerConfig.getId(), recordInput.getStartTime(),recordInput.getEndTime(), recordInput.getRecord()));

        addCharacterExp(record);

        return record.getId();
    }

    private void addCharacterExp(Record record) {
        var user = userRepository.findById(headerConfig.getId()).orElseThrow();

        var character = user.getCharacter();

        character.addExp(record.getValue());

        userRepository.save(user);
    }
}
