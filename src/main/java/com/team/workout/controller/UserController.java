package com.team.workout.controller;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.team.workout.domain.User;
import com.team.workout.dto.UserInput;
import com.team.workout.repository.UserRepository;
import com.team.workout.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController implements GraphQLResolver {

    private final UserService userService;

    @QueryMapping
    public List<User> users(){
        var result = userService.users();
        return result;
    }

    @QueryMapping
    public User getUser(@Argument(name="name") String name){
        var result = userService.getUser(name);
        return result;
    }


    @MutationMapping
    public void saveUser(@Argument(name = "user") UserInput user){
        userService.saveUser(user);
    }

    @MutationMapping
    public void quitUser(@Argument(name = "id") String id){
        userService.quitUser(id);
    }
}