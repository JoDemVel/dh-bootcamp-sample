package com.dharbor.stock.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Josue Veliz
 */
@Getter
@Setter
@Entity
@Table(name = "product_reservations")
public class ProductReservation {

    @Id
    private String id;

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Long createdAt;

    @PrePersist
    void onPrePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = System.currentTimeMillis();
    }
}
