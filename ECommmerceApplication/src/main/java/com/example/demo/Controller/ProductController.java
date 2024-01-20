package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Error.CustomException;
import com.example.demo.Exception.InternalServiceException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Manager.ProductManager;
import com.example.demo.Response.BaseResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductManager productManager;
    @SneakyThrows
    @GetMapping("/getProduct/{productId}")
    public BaseResponse getProduct(@PathVariable String productId) {
        if (productId == null) {
            throw new CustomException("error null", HttpStatus.BAD_REQUEST);
        }
        try {
            Product product = productManager.getProductData(productId);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setBody(product);
            baseResponse.setStatus("SUCCESS");
            baseResponse.setResultCode(200);
            return baseResponse;

        } catch (ResourceNotFoundException e) {
            throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InternalServiceException e) {
            throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
