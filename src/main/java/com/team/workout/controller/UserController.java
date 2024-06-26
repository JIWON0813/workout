package com.team.workout.controller;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.team.workout.domain.User;
import com.team.workout.dto.request.UserInput;
import com.team.workout.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController implements GraphQLResolver {

    private final UserService userService;

    @QueryMapping
    public List<User> users(){
        return userService.users();
    }

    @QueryMapping
    public User user(){
        return userService.user();
    }

    @MutationMapping
    public void createUser(@Argument(name = "user") UserInput user){
        userService.create(user);
    }

    @MutationMapping
    public void quitUser(){
        userService.quit();
    }

    @MutationMapping
    public void deleteUser(){
        userService.delete();
    }

    @QueryMapping
    public String test(){
        return "hi";
    }
}