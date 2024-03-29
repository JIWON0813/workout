package com.team.workout.user;

import com.team.workout.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
public class UserTests {

    @Test
    void test01(){
        User user = new User();
        LocalDateTime startTime = LocalDateTime.of(2024,3,8,14,30,23);
        LocalDateTime endTime = LocalDateTime.of(2024,3,8,14,55,46);

        //RecordInput recordInput = new RecordInput(1234, startTime, endTime);

//        user.addRecord(recordInput);

        //assertThat().isEqualTo("");
    }

    @Test
    void functionTest(){
        HashMap<Integer, HashMap<Integer, String>> map = new HashMap<>();

        map.putIfAbsent(1, new HashMap<>());

        var data = map.get(1);
        data.put(100,"hello");

        assertThat(map.get(1).get(100)).isEqualTo("hello");
    }
}
