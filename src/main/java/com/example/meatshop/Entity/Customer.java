package com.example.meatshop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
