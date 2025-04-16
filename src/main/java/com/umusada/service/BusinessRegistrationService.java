package com.umusada.service;

import com.umusada.dto.bank.BusinessRequest;
import com.umusada.entity.bank.BusinessRequestEntity;
import com.umusada.repo.bank.BusinessRequestRepository;
import com.umusada.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BusinessRegistrationService {

    private final RestTemplate restTemplate;
    private final BusinessRequestRepository repository;

    private final String apiUrl = "https://external-api.com/submit"; // replace

    public ResponseEntity<Object> sendRegistrationRequest(BusinessRequest request) {
        BusinessRequestEntity entity = BusinessRequestEntity.builder()
                .messageId(request.getMessageId())
                .requestTime(LocalDateTime.now())
                .requestPayload(JsonUtil.toJson(request))
                .build();

        repository.save(entity);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<BusinessRequest> httpEntity = new HttpEntity<>(request, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, httpEntity, String.class);

            entity.setResponseTime(LocalDateTime.now());
            entity.setThirdPartyResponse(response.getBody());
            entity.setResponseStatus(String.valueOf(response.getStatusCodeValue()));
            repository.save(entity);

            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (RestClientException ex) {
            entity.setResponseTime(LocalDateTime.now());
            entity.setResponseStatus("ERROR");
            entity.setThirdPartyResponse(ex.getMessage());
            repository.save(entity);

            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to send request to external API");
            errorResponse.put("error", ex.getMessage());
            errorResponse.put("messageId", request.getMessageId());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}

