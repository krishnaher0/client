package com.example.meatshop.Pojo;

import com.example.meatshop.Entity.MeatCategory;
import com.example.meatshop.Entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ItemsPojo {
    @Id
    private Integer id;

    private Integer price;
    private String itemName;
    private String itemDetails;
    private MeatCategory categoryId;
    private Order order;

}
