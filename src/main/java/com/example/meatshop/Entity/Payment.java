package com.example.meatshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="Payment")
public class Payment {
    @Id
    private Integer paymentId;

    @Column(name="PaymentDate")
     private LocalDate paymentDate;

//    @OneToOne
//    @JoinColumn(name="Price")
//    private Order orderId;

    @ManyToOne
    @JoinColumn(name="CustomerId")
    private Customer customerId;


}
