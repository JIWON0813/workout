package com.team.workout.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.team.workout.repository.TestRepository;
import com.team.workout.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {
    private TestRepository testRepository;
    private UserRepository userRepository;

}
