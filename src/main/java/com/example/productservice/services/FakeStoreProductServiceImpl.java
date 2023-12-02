package com.example.productservice.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("fakeStoreProductServiceImpl") //define the name for further use like use in controller
public class FakeStoreProductServiceImpl implements ProductService{
    @Override
    public String getProductById(long id) {
        return "Product fetched with id " + id + " from service";
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
