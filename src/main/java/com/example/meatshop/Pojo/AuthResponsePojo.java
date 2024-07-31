package com.example.meatshop.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthResponsePojo {
    private String accessToken;
    private Integer userId;
    private List<String> roles;
}
