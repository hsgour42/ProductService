package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {
     GenericProductDto getProductById(long id);

     List<GenericProductDto> getAllProduct();

     GenericProductDto deleteProductById(long id);

     GenericProductDto createProduct(GenericProductDto genericProductDto);

     GenericProductDto updateProductById( long id);
}
