package com.example.demo.Database;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@Data
public class ProductRelatedData {

    public void addProduct(HashMap<String, Object> product) {
        productsList.add(product);
    }
    public List<HashMap<String, Object>> productsList = Arrays.asList(
            new HashMap<>() {{
                put("productId", "p1");
                put("name", "Smartphone");
                put("description", "High-end smartphone");
                put("price", 799.99);
                put("stockQuantity", 100);
                put("brand", "BrandX");
            }},

            new HashMap<>() {{
                put("productId", "p2");
                put("name", "Laptop");
                put("description", "Powerful laptop for work and gaming");
                put("price", 1299.99);
                put("stockQuantity", 50);
                put("brand", "TechCorp");
            }},

            new HashMap<>() {{
                put("productId", "p3");
                put("name", "Wireless Earbuds");
                put("description", "Bluetooth earbuds with noise cancellation");
                put("price", 89.99);
                put("stockQuantity", 200);
                put("brand", "AudioTech");
            }}
    );
}
