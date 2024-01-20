package com.example.demo.Controller;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.User;
import com.example.demo.Error.CustomException;
import com.example.demo.Exception.InternalServiceException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Manager.CartManager;
import com.example.demo.Manager.ProductManager;
import com.example.demo.Request.AddToCartRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    private CartManager cartManager;
    @GetMapping("/getCart/{userId}")
    public Cart getCart(@PathVariable String userId) {
        if (userId == null) {
            throw new CustomException("error null", HttpStatus.BAD_REQUEST);
        }
        try {
//            return cartManager.addToCart(userId);
            return null;
        } catch (ResourceNotFoundException e) {
            throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InternalServiceException e) {
            throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addToCart")
    public Cart addToCart(@RequestBody AddToCartRequestBody request) {
        if (request == null || request.getUserId() == null || request.getProductId() == null) {
            throw new CustomException("error null", HttpStatus.BAD_REQUEST);
        }
        try {
            return cartManager.addToCart(request.getUserId(), request.getProductId(), request.getQuantity());
        } catch (ResourceNotFoundException e) {
            throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InternalServiceException e) {
            throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
