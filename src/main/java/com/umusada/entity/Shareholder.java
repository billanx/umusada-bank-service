package com.umusada.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "shareholders")
public class Shareholder extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String msisdn;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;
}

