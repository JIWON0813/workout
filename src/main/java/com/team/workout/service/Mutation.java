package com.team.workout.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.team.workout.repository.TestRepository;
import com.team.workout.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private TestRepository testRepository;
    private UserRepository userRepository;

}
