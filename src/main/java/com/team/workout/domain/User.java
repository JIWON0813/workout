package com.team.workout.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String token;

    private String name;

    private String email;

    private boolean isQuit;

    private Character character;

    private boolean isAgreeMarketing;

    public void quit(){
        this.isQuit = true;
    }

}
