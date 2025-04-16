package com.umusada.entity.umusada;

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
@Table(name = "additional_data")
public class AdditionalData extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notification_key")
    private String notificationKey;
    @Column(name = "notification_value")
    private String notificationValue;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;
}

