package com.umusada.dto.bank;

import lombok.Data;
import java.util.List;

@Data
public class CallbackResponse {
    private String statusCode;
    private String statusDescription;
    private String messageCode;
    private String messageDescription;
    private List<ErrorInfo> errorInfo;
    private String messageId;
    private String conversationId;
    private Object primaryData; // Can replace with actual class if needed
    private List<AdditionalData> additionalData;
}

