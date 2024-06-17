package com.example.meatshop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name="Cart Items")
public class ProductCart {
    @Id
    private Integer id;
    @Column(name="name")
    private String productName;


}
