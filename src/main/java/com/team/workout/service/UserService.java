package com.team.workout.service;

import com.team.workout.domain.Character;
import com.team.workout.domain.Month;
import com.team.workout.domain.User;
import com.team.workout.domain.Year;
import com.team.workout.dto.RecordInput;
import com.team.workout.dto.UserInput;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    public List<User> users(){
        var result = userRepository.findAll();
        return result;
    }

    public User getUser(String name){
        var result = userRepository.findByName(name);
        return result;
    }

    public void createUser(UserInput user){
         userRepository.save(new User(user.getId(), user.getToken(), user.getName(), user.getEmail(), false, new Character(1,0.0), new ArrayList<>()));
    }

    public void createRecord(RecordInput record){
        var user = userRepository.findById(record.getId()).orElseThrow();

        var years = user.getYears();

        user.addRecord(record);

        userRepository.save(user);
    }

    public boolean quitUser( String id){
        var user = userRepository.findById(id).orElseThrow();

        user.quit();

        userRepository.save(user);

        return true;
    }
}
