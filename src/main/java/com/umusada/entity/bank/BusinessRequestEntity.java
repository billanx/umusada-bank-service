package com.umusada.entity.bank;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessRequestEntity {

    @Id
    private String messageId;

    private LocalDateTime requestTime;
    @Lob
    private String requestPayload;

    private LocalDateTime responseTime;
    @Lob
    private String thirdPartyResponse;
    private String responseStatus; // HTTP status or custom status

    private LocalDateTime callbackTime;
    private String callbackStatus; // success/failure or statusCode
    @Lob
    private String callbackPayload;
}
