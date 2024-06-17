package com.example.meatshop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category")
@Getter
@Setter

public class MeatCategory {
    @Id
    private Integer id;

    @Column(name="Category Name")
    private String categoryName;

    @Column(name="description")
    private  String description;

}
