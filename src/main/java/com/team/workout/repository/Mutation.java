package com.team.workout.repository;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.team.workout.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private UserRepository userRepository;
    private RecordRepository recordRepository;
}
