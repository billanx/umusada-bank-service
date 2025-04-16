package com.umusada.entity.umusada;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "stock")
public class Stock {
    @Id
    @OneToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(name = "total_value")
    private Long totalValue;

    @Column(name = "today")
    private Date today;
}
