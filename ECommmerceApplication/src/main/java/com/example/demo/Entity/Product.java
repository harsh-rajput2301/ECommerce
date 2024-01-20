package com.example.demo.Entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private String brand;

}