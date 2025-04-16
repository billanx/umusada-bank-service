package com.umusada;

import com.umusada.controller.BusinessRegistrationController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BusinessRegistrationController.class)
public class BusinessRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnOkWhenValidRequest() throws Exception {
        String json = """
        {
          "messageId": "REQ123",
          "primaryData": {
            "name": "Union Berlin Limited",
            "valueChain": "Manufacturing",
            "businessTin": "1154003",
            "category": "RETAILER",
            "registrationCode": "1154535003",
            "email": "unionmarkets@gmail.com",
            "location": "Kimironko",
            "status": true,
            "accounts": [{"name": "Union Market", "number": "2345678909871003"}],
            "directors": [{
              "firstName": "Patrick",
              "middleName": "Imanzi",
              "lastName": "III",
              "documentType": "001",
              "documentNumber": "24454346",
              "msisdn": "+25071234575",
              "status": true
            }],
            "subscribers": [{
              "firstName": "John",
              "middleName": "X",
              "lastName": "Doe",
              "documentType": "001",
              "documentNumber": "244543463",
              "msisdn": "+25071234575",
              "status": true
            }],
            "notifications": [{"key": "emails", "value": "unionmarkets@gmail.com"}],
            "additionalData": [{"key": "branch", "value": "Kabuga"}]
          }
        }
        """;

        mockMvc.perform(post("/api/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}

