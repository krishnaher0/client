package com.example.meatshop.Shared;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class GlobalApiResponse<T> {
    private String message;
    private  Integer statusCode;
    private  T data;
}
