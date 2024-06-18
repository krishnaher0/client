package com.example.meatshop.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name="Items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="Item Name")
    private String itemName;

    @Column(name="price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private MeatCategory categoryId;

    @Column(name="ItemDetails")
    private String itemDetails;




}
