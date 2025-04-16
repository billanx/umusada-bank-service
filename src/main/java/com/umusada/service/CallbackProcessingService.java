package com.umusada.service;

import com.umusada.dto.bank.CallbackResponse;
import com.umusada.entity.bank.BusinessRequestEntity;
import com.umusada.repo.bank.BusinessRequestRepository;
import com.umusada.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CallbackProcessingService {

    private final BusinessRequestRepository repository;

    public ResponseEntity<Object> handleCallback(CallbackResponse response) {
        try {
            BusinessRequestEntity entity = repository.findById(response.getMessageId())
                    .orElseThrow(() -> new RuntimeException("Request with messageId " + response.getMessageId() + " not found"));

            entity.setCallbackTime(LocalDateTime.now());
            entity.setCallbackStatus(response.getStatusCode());
            entity.setCallbackPayload(JsonUtil.toJson(response));

            repository.save(entity);

            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("message", "Callback processed successfully");
            successResponse.put("messageId", response.getMessageId());

            return ResponseEntity.ok(successResponse);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Error processing callback");
            errorResponse.put("reason", e.getMessage());
            errorResponse.put("messageId", response.getMessageId());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}

