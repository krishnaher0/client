package com.example.meatshop.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category")
@Getter
@Setter

public class MeatCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="Category Name")
    private String categoryName;

    @Column(name="description")
    private  String description;

}
