package com.team.workout.domain;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String token;

    @Size(max = 9, message = "8자를 초과할 수 없습니다.")
    private String name;

    private String email;

    private boolean isQuit;

    private Character character;

    private boolean isAgreeMarketing;

    @CreatedDate
    private LocalDateTime createdDate;

    public void quit(){
        this.isQuit = true;
    }

}
