package com.team.workout.user;

import com.team.workout.domain.User;
import com.team.workout.dto.RecordInput;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class UserTests {
    @Test
    void test01(){
        User user = new User();
        LocalDateTime startTime = LocalDateTime.of(2024,3,8,14,30,23);
        LocalDateTime endTime = LocalDateTime.of(2024,3,8,14,55,46);

        RecordInput recordInput = new RecordInput("1234", startTime, endTime);

        user.addRecord(recordInput);

        var asd = "2";
    }
}
