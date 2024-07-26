package com.example.meatshop.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactPojo {
    private String name;
    private String email;
    private String message;
    private Long customerId;
}
