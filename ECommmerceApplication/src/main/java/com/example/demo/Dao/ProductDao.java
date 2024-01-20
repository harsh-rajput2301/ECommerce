package com.example.demo.Dao;

import com.example.demo.Database.ProductRelatedData;
import com.example.demo.Database.UserRelatedData;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Exception.ProductDAOException;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Exception.UserDAOException;
import com.example.demo.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    ProductRelatedData productRelatedData;
    public Product getProduct(String productId) {
        //we are assuming this has been returned by database

        List<HashMap<String, Object>> databaseReturnedProductData = null;
        try {
            databaseReturnedProductData = productRelatedData.getProductsList();
        } catch (Exception e) {
            throw new ProductDAOException(e.getMessage());
        }
        HashMap<String, Object> productData = null;
        for (HashMap<String, Object> i: databaseReturnedProductData) {
            if (i.get("productId").equals(productId)) {
                productData = i;
            }
        }
        if (productData == null) {
            throw new ProductNotFoundException("Product not found: " + productId);
        }
        Product product = Product.builder().productId(productId).name((String) productData.get("name")).description((String) productData.get("description")).price((Double) productData.get("price")).stockQuantity((int) productData.get("stockQuantity")).brand((String) productData.get("brand")).build();
        return product;
    }
}
