package com.umusada.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "purchases",
        uniqueConstraints = @UniqueConstraint(columnNames = {"business", "month", "year"}))
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int month;
    private int invoiceCount;
    private Double poValue;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    private int year;
}
