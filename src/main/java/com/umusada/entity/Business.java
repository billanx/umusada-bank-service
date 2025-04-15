package com.umusada.entity;

import com.umusada.enums.BusinessCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "businesses")
public class Business extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String valueChain;
    private String businessTin;

    @Enumerated(EnumType.STRING)
    private BusinessCategory category;

    private String registrationCode;
    private String email;
    private String location;
    private Boolean status;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shareholder> shareholders;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> subscribers;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdditionalData> additionalData;

    @OneToMany(mappedBy = "business",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;
}
