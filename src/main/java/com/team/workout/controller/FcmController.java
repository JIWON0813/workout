package com.team.workout.controller;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.team.workout.dto.MessageRequest;
import com.team.workout.service.FcmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FcmController implements GraphQLResolver {

    private final FcmService fcmService;

    @MutationMapping
    public void sendMessageToken(@Argument(name = "message") MessageRequest requestDTO) throws FirebaseMessagingException {
        fcmService.sendMessageByToken(requestDTO.getTitle(), requestDTO.getBody(), requestDTO.getTargetToken());
    }
}
