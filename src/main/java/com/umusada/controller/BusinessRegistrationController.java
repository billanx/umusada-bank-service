package com.umusada.controller;

import com.umusada.dto.bank.BusinessRequest;
import com.umusada.service.BusinessRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class BusinessRegistrationController {

    private final BusinessRegistrationService service;

    @PostMapping
    public ResponseEntity<?> registerBusiness(@RequestBody BusinessRequest request) {
        return service.sendRegistrationRequest(request);
    }
}


