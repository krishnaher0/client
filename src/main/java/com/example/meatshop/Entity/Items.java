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

@Table(name="Items")
public class Items {
    @Id
    private Integer id;
    @Column(name="Item Name")
    private String itemName;

    @Column(name="price")
    private Integer price;

    @Column(name="ProductDetails")
    private String productDetails;




}
