package com.example.productservice.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public String getProductById(long id) {
        return null;
    }

    @Override
    public void getAllProduct() {

    }

    @Override
    public void deleteProductById(long id) {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById(long id) {

    }
}
