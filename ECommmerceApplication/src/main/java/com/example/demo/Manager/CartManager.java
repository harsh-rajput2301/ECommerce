package com.example.demo.Manager;

import com.example.demo.Entity.Cart;

public interface CartManager {
    public Cart addToCart(String userId, String productId, int quantity);
}
