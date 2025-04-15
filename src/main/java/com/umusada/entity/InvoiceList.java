package com.umusada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoice_list",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_invoice", "list_id_product"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "list_id_product", nullable = false)
    private Integer listIdProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_invoice", nullable = false)
    @JsonBackReference
    private Invoice invoice;

    @Column(name = "code_uni", length = 30)
    private String codeUni;

    @Column(name = "num_lot", length = 50)
    private String numLot;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "prix_revient", columnDefinition = "DOUBLE DEFAULT 0")
    private Double prixRevient;

    @Column(name = "scanned", length = 1, columnDefinition = "CHAR(1) DEFAULT '0'")
    private String scanned;

    @Column(name = "date_exp", length = 16, columnDefinition = "VARCHAR(16) DEFAULT '101010'")
    private String dateExp;

    @Column(name = "bon_livraison", length = 50, nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'BLA01'")
    private String bonLivraison;

    @Column(name = "qte_retourne")
    private Integer qteRetourne;

    @Column(name = "tva")
    private Double tva;

    @Column(name = "original_price")
    private Double originalPrice;

    @Column(name = "key_invoice", length = 200)
    private String keyInvoice;

    @Column(name = "warehouse", length = 100, columnDefinition = "VARCHAR(100) DEFAULT 'PRINCIPALE'")
    private String warehouse;

    @Column(name = "igicuma_status", length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'NO'")
    private String igicumaStatus;

    @Column(name = "tax_code", length = 10)
    private String taxCode;

    @Column(name = "state", length = 10)
    private String state;
}

