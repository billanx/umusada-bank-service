package com.umusada.controller;

import com.umusada.dto.bank.CallbackResponse;
import com.umusada.service.CallbackProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/callback")
@RequiredArgsConstructor
public class CallbackController {

    private final CallbackProcessingService service;

    @PostMapping
    public ResponseEntity<Void> receiveCallback(@RequestBody CallbackResponse callbackResponse) {
        service.handleCallback(callbackResponse);
        return ResponseEntity.ok().build();
    }
}

