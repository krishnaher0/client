package com.example.meatshop.Pojo;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.Items;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public class PaymentPojo {
    private Integer id;

    private String type;

    private String amount;
    private LocalDate date;
    private Customer customer;
    private Items items;
}

