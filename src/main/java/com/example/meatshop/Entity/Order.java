package com.example.meatshop.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity


@Table(name="Orders Table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    @ManyToOne
  @JoinColumn(name="CustomerId")
    private Customer customerId;

  @OneToMany
    @JoinColumn(name="Items")
    private List<Items> items;

//    @Column(name="Payment Type")
//    private String paymentType;

    @Column(name="order date")
    private LocalDate orderDate;


}
