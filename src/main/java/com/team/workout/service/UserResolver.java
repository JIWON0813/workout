package com.team.workout.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.team.workout.domain.User;
import com.team.workout.dto.UserInput;
import com.team.workout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserResolver implements GraphQLResolver {

    private final UserRepository userRepository;

    @QueryMapping
    public List<User> users(){
        var result = userRepository.findAll();
        return result;
    }

    @QueryMapping
    public User getUser(@Argument(name="name") String name){
        var result = userRepository.findByName(name);
        return result;
    }


    @MutationMapping
    public User saveUser(@Argument(name = "user") UserInput user){
        if(user.getId() == null){
            throw  new IllegalArgumentException("잘못된 ID가 들어왔습니다.");
        }

        var result = userRepository.save(new User(user.getId(), user.getName(), ""));
        return result;
    }

    @MutationMapping
    public boolean quitUser(@Argument(name = "id") String id){
        return true;
    }
}
