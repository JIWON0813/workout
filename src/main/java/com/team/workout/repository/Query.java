package com.team.workout.repository;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.team.workout.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {
    private UserRepository userRepository;

}
