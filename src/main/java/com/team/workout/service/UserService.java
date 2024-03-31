package com.team.workout.service;

import com.team.workout.config.HeaderConfig;
import com.team.workout.domain.Character;
import com.team.workout.domain.User;
import com.team.workout.domain.Record;
import com.team.workout.dto.request.UserInput;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final HeaderConfig headerConfig;

    public List<User> users(){
        return userRepository.findAll();
    }

    public User user(){
        return userRepository.findById(headerConfig.getId()).orElse(null);
    }

    public void create(UserInput userInput){
        var user = User.builder()
                        .id(userInput.getId())
                        .token(userInput.getToken())
                        .name(userInput.getName())
                        .email(userInput.getEmail())
                        .character(new Character(userInput.getCharacterName()))
                        .isAgreeMarketing(userInput.isMarketing())
                        .createdDate(LocalDateTime.now())
                        .build();

        userRepository.save(user);
    }

    public void quit(){
        var user = userRepository.findById(headerConfig.getId()).orElseThrow();

        user.quit();

        userRepository.save(user);
    }

    public void delete(){
        userRepository.deleteById(headerConfig.getId());
    }
}
