package com.example.demo.Request;

import lombok.Data;

@Data
public class AddToCartRequestBody {
    private String userId;
    private String productId;
    private int quantity;
}
