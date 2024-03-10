package com.team.workout.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.team.workout.domain.User;
import com.team.workout.dto.UserInput;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
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

    public User getUser(@Argument(name="name") String name){
        var result = userRepository.findByName(name);
        return result;
    }

    public void saveUser(@Argument(name = "user") UserInput user){
        if(user.getId() == null){
            throw  new IllegalArgumentException("잘못된 ID가 들어왔습니다.");
        }

        var result = userRepository.save(new User(user.getId(), user.getToken(), user.getName(), user.getEmail()));
    }

    public boolean quitUser(@Argument(name = "id") String id){
        return true;
    }
}
