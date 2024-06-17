package com.example.meatshop.Shared;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter


public class GlobalApiResponse<T> {
    private String message;
    private  Integer statusCode;
    private  T data;
}
