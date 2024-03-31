package com.team.workout.service;

import com.team.workout.config.HeaderConfig;
import com.team.workout.domain.Record;
import com.team.workout.dto.request.RecordInput;
import com.team.workout.dto.response.RecordResponse;
import com.team.workout.repository.RecordRepository;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.team.workout.constants.RecordConstant.MAX_SEED_STANDARD;
import static com.team.workout.constants.RecordConstant.SEED_STANDARD_TIME;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final UserRepository userRepository;
    private final RecordRepository recordRepository;
    private final HeaderConfig headerConfig;

    public List<Record> records(){
        return recordRepository.findAllByUserId(headerConfig.getId());
    }

    public List<Record> recordsByDay(LocalDate localDate){
        return recordRepository.findAllByStartTimeBetweenAndUserId(localDate.atStartOfDay(), localDate.atStartOfDay().plusDays(1).minusSeconds(1), headerConfig.getId());
    }

    public void deleteRecordsByDay(LocalDate localDate){
        recordRepository.deleteAllByStartTimeBetweenAndUserId(localDate.atStartOfDay(), localDate.atStartOfDay().plusDays(1).minusSeconds(1), headerConfig.getId());
    }

    public long seeds(LocalDate localDate){
        long seeds = sumSeedsByDay(localDate);

        return seeds > 12 ? 12 : seeds;
    }

    //TODO 리팩터링 필요
    public RecordResponse addRecord(RecordInput recordInput) {
        boolean isMax = checkMax(recordInput);

        var record = recordRepository.save(new Record(headerConfig.getId(), recordInput.getStartTime(),recordInput.getEndTime(), recordInput.getRecord()));

        return new RecordResponse(record.getId(), isMax);
    }

    private boolean checkMax(RecordInput recordInput) {
        var sum = sumSeedsByDay(LocalDate.from(recordInput.getStartTime()));

        if(sum >= MAX_SEED_STANDARD){
            return true;
        }

        var newSeeds = recordInput.getRecord() / SEED_STANDARD_TIME;

        if(sum + newSeeds>= MAX_SEED_STANDARD){
            addCharacterExp(MAX_SEED_STANDARD - sum);
            return true;
        }

        addCharacterExp(newSeeds);
        return false;
    }

    private long sumSeedsByDay(LocalDate localDate) {
        var recordsByDay = this.recordsByDay(localDate);
        return recordsByDay.stream().mapToLong(i -> i.getSeeds()).sum();
    }

    private void addCharacterExp(long record) {
        var user = userRepository.findById(headerConfig.getId()).orElseThrow();

        var character = user.getCharacter();

        character.addExp(record);

        userRepository.save(user);
    }

}
