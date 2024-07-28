package com.example.meatshop.Pojo;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.Items;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsPojo {
    private String username;
    private String email;
    private String cardNumber;
    private String cvvNumber;
    private String expiryDate;
    private Customer customer;
    private Items items;
    private LocalDate paymentDateTime;
    private Integer totalQuantity;
    private Integer totalPrice;
}
