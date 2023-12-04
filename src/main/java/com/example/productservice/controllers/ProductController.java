package com.example.productservice.controllers;


import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.services.FakeStoreProductServiceImpl;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //this is not simple controller rather this is had rest api
@RequestMapping("/products")  //all api go through this path {common root}
public class ProductController {

    ProductService productService;

    //constructor injection
    @Autowired
    ProductController(@Qualifier("fakeStoreProductServiceImpl") ProductService productService){
            this.productService = productService;
    }

    //localhost:8080/products/123
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") long id) {

        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProduct(){
        return productService.getAllProduct();
    };

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") long id){
        return productService.deleteProductById(id);
    };

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    };

    @PatchMapping("/{id}")
    public GenericProductDto updateProductById(@PathVariable("id") long id,@RequestBody GenericProductDto genericProductDto){
        return productService.updateProductById(id);
    };
}
