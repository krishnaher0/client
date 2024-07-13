package com.example.meatshop.Pojo;

import lombok.Data;

@Data
public class AuthResponsePojo {
    private String accessToken;
    private String tokenType="Bearer";

    public AuthResponsePojo(String accessToken) {
        this.accessToken = accessToken;

    }
}
