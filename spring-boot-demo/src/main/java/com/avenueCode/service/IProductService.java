package com.avenueCode.service;

import java.util.List;

import com.avenueCode.entity.Product;


public interface IProductService {
     List<Product> getAllProducts();
     List<Product> getAllProductsWithChild();
     Product getProductById(int productId);
     boolean addProduct(Product product);
     void updateProduct(Product product);
     void deleteProduct(int productId);
}
