package com.umusada.entity.umusada;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "sales",
        uniqueConstraints = @UniqueConstraint(columnNames = {"business", "month", "year"}))
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int month;
    private int invoiceCount;
    private Double salesValue;
    private Double totalVat;
    private Double cash;
    private Double credit;
    private int year;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;
}
