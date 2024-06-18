package com.example.meatshop.Pojo;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.Items;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderPojo {
    private Integer orderId;
    private Customer customerId;
    private List<ItemsPojo> items;
//    private String paymentType;
    private LocalDate orderDate;
}
