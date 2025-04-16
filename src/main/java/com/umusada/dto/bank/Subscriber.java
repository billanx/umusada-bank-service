package com.umusada.dto.bank;

import lombok.Data;

@Data
public class Subscriber {
    private String firstName;
    private String middleName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String msisdn;
    private boolean status;
}

