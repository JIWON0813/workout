package com.team.workout.user;

import com.team.workout.domain.Character;
import com.team.workout.domain.Record;
import com.team.workout.domain.User;
import com.team.workout.dto.request.RecordInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class RecordTests {
    @Test
    @DisplayName("경험치 계산")
    void addExpTest(){
        Character character = new Character("hello");
        character.addExp(1);
        character.addExp(1);
        character.addExp(1);

        var exp = character.getLevel();

        assertThat(exp).isEqualTo(1);
    }

    @Test
    @DisplayName("일일 운동량 초과한 요청")
    void max(){

    }


    @Test
    @DisplayName("JAVA 기능 테스트용")
    void locaDate(){
        LocalDate date = LocalDate.now();

        var asd = date.atStartOfDay().plusDays(1);
        var asd2 = date.atStartOfDay().plusDays(1).minusSeconds(1);

        var asd33 = "asd";

        long a = 600;
        long b = 633;

        long c = b/a;

        var d = c;
    }
}
