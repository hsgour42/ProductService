package com.example.productservice.services;

import org.springframework.web.bind.annotation.*;

public interface ProductService {
     String getProductById(long id);

     void getAllProduct();

     void deleteProductById(long id);

     void createProduct();

     void updateProductById( long id);
}
