package com.example.meatshop.Pojo;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPojo {
    private Integer customerId;
    private String customerName;
    private String address;
    private String email;
    private String contactNo;
}
