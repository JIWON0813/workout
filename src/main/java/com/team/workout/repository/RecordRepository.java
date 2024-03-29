package com.team.workout.repository;


import com.team.workout.domain.Record;
import com.team.workout.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface RecordRepository extends MongoRepository<Record, String> {
    List<Record> findAllByUserId(String userId);
    List<Record> findAllByStartTimeBetweenAndUserId(LocalDateTime startTime, LocalDateTime endTime, String userId);

    //admin
    List<Record> deleteAllByStartTimeBetweenAndUserId(LocalDateTime atStartOfDay, LocalDateTime minusSeconds, String id);
}
