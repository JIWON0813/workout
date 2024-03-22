package com.team.workout.service;

import com.team.workout.domain.Character;
import com.team.workout.domain.User;
import com.team.workout.domain.UserRecord;
import com.team.workout.dto.request.UserInput;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    public List<User> users(){
        var result = userRepository.findAll();
        return result;
    }

    public User getUser(String id){
        var result = userRepository.findById(id).orElse(null);
        return result;
    }

    public User createUser(UserInput userInput){
        var user = User.builder()
                        .id(userInput.getId())
                        .token(userInput.getToken())
                        .name(userInput.getName())
                        .email(userInput.getEmail())
                        .character(new Character(userInput.getCharacterName()))
                        .userRecord(new UserRecord())
                        .build();

         return userRepository.save(user);
    }

    public boolean quitUser( String id){
        var user = userRepository.findById(id).orElseThrow();

        user.quit();

        userRepository.save(user);

        return true;
    }
}
