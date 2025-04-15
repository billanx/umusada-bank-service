package com.umusada.entity;

import com.umusada.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"invoiceNumber", "owner_id"})
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String invoiceNumber;

    private String productId;
    private String currency;

    private BigDecimal invoiceAmount;
    private BigDecimal loanAmount;

    private LocalDateTime invoiceCreationDate;
    private LocalDateTime invoiceExpiryDate;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    // Supplier (Anchor / Distributor)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Business supplier;

    // Owner (Retailer / Buyer who owns this invoice)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Business owner;
}

