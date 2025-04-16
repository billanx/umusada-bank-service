package com.umusada;

import com.umusada.dto.bank.CallbackResponse;
import com.umusada.entity.bank.BusinessRequestEntity;
import com.umusada.repo.bank.BusinessRequestRepository;
import com.umusada.service.CallbackProcessingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class) // Use Mockito extension
public class CallbackProcessingServiceTest {

    @Mock
    private BusinessRequestRepository repository; // Mock the repository

    @InjectMocks
    private CallbackProcessingService callbackProcessingService; // Inject mocks into the service being tested

    private BusinessRequestEntity existingEntity;

    @BeforeEach
    void setUp() {
        existingEntity = BusinessRequestEntity.builder()
                .messageId("REQ234601P43")
                .requestPayload("{}")
                .requestTime(LocalDateTime.now())
                .build();

        when(repository.findById("REQ234601P43")).thenReturn(Optional.of(existingEntity));
    }

    @Test
    void shouldProcessCallbackSuccessfully() {
        CallbackResponse callback = new CallbackResponse();
        callback.setMessageId("REQ234601P43");
        callback.setStatusCode("1");
        callback.setStatusDescription("FAILURE");
        callback.setMessageCode("400");
        callback.setMessageDescription("Business already registered.");

        callbackProcessingService.handleCallback(callback);

        ArgumentCaptor<BusinessRequestEntity> captor = ArgumentCaptor.forClass(BusinessRequestEntity.class);
        verify(repository, times(1)).save(captor.capture());

        BusinessRequestEntity savedEntity = captor.getValue();
        assertThat(savedEntity.getCallbackStatus()).isEqualTo("1");
        assertThat(savedEntity.getCallbackPayload()).contains("Business already registered");
        assertThat(savedEntity.getCallbackTime()).isNotNull();
    }
}

