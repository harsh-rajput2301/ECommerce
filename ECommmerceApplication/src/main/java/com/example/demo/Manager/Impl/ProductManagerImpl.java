package com.example.demo.Manager.Impl;

import com.example.demo.Dao.ProductDao;
import com.example.demo.Entity.Product;
import com.example.demo.Exception.*;
import com.example.demo.Manager.ProductManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductManagerImpl implements ProductManager {

    @Autowired
    ProductDao productDao;
    @Override
    public Product getProductData(String productId) {
        try {
            log.info("Get product triggered for the id= {}", productId);
            return productDao.getProduct(productId);
        } catch (ProductNotFoundException e) {
            String errorMsg = String.format("product not found for userId: %s ", productId);
            log.warn("{} Exception: {}", errorMsg, e.getMessage());
            throw new ResourceNotFoundException(errorMsg);
        } catch (ProductDAOException e) {
            throw new InternalServiceException(e.getMessage());
        }
    }
}
