package com.umusada.entity;

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
@Table(name = "notifications")
public class Notification extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_key")
    private String contactKey;

    @Column(name = "contact_value")
    private String contactValue;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;
}


