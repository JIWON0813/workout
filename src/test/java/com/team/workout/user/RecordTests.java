package com.team.workout.user;

import com.team.workout.domain.Character;
import com.team.workout.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

@SpringBootTest
public class RecordTests {

    @Test
    @DisplayName("일시정지로 들어왔을 때")
    void test01(){
        User user = new User();
        LocalDateTime startTime = LocalDateTime.of(2024,3,8,14,30,23);
        LocalDateTime endTime = LocalDateTime.of(2024,3,8,14,55,46);

        //RecordInput recordInput = new RecordInput(1234, startTime, endTime);

//        user.addRecord(recordInput);

    }
    @Test
    @DisplayName("운동 끝으로 들어왔을 때")
    void test02(){
        User user = new User();
        LocalDateTime startTime = LocalDateTime.of(2024,3,8,14,30,23);
        LocalDateTime endTime = LocalDateTime.of(2024,3,8,14,55,46);

        //RecordInput recordInput = new RecordInput(1234, startTime, endTime);

//        user.addRecord(recordInput);
    }

    @Test
    @DisplayName("경험치 계산")
    void addExpTest(){
        Character character = new Character("hello");
        character.addExp(100);
        character.addExp(100);
        character.addExp(836);

        var exp = character.getExp();
    }
}
