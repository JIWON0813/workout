package com.team.workout.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.team.workout.dto.MessageRequest;
import com.team.workout.service.FcmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FcmController {

    private final FcmService fcmService;

    @PostMapping("/message/fcm/token")
    public ResponseEntity sendMessageToken(@RequestBody MessageRequest requestDTO) throws IOException, FirebaseMessagingException {
        fcmService.sendMessageByToken(requestDTO.getTitle(), requestDTO.getBody(), requestDTO.getTargetToken());
        return ResponseEntity.ok().build();
    }
}
