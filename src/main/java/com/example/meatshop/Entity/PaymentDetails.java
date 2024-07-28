package com.example.meatshop.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "paymentDetails")
@Data
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String cvvNumber;

    @Column(nullable = false)
    private String expiryDate;

    @Column(nullable = false)
    private Integer totalQuantity;

    @Column(nullable = false)
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Items items;

    @Column(nullable = false)
    private LocalDate paymentDateTime;

}
