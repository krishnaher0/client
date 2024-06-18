package com.example.meatshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @Column(name="Name")
    private String customerName;

    @Column(name="Address")
    private String address;

    @Column(name="Email")
    private String email;

    @Column(name="contact")
    private String contactNo;



}
