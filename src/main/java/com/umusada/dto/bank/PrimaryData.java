package com.umusada.dto.bank;

import lombok.Data;
import java.util.List;

@Data
public class PrimaryData {
    private String name;
    private String valueChain;
    private String businessTin;
    private String category;
    private String registrationCode;
    private String email;
    private String location;
    private boolean status;
    private List<Account> accounts;
    private List<Director> directors;
    private List<Subscriber> subscribers;
    private List<Notification> notifications;
    private List<AdditionalData> additionalData;
}

