package com.team.workout.repository;


import com.team.workout.domain.Record;
import com.team.workout.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface RecordRepository extends MongoRepository<Record, String> {
    List<Record> findAllByUserId(String userId);
}
