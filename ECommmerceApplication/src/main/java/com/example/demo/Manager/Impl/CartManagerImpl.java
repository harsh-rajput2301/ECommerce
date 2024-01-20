package com.example.demo.Manager.Impl;

import com.example.demo.Entity.Cart;
import com.example.demo.Manager.CartManager;
import org.springframework.stereotype.Service;

@Service
public class CartManagerImpl implements CartManager {
    @Override
    public Cart addToCart(String userId, String productId, int quantity) {
        return null;
    }
}
