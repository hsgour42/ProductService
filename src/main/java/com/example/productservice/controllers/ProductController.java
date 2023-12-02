package com.example.productservice.controllers;


import com.example.productservice.services.FakeStoreProductServiceImpl;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public String getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public void getAllProduct(){

    };

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") long id){

    };

    @PostMapping
    public void createProduct(){

    };

    @PatchMapping("/{id}")
    public void updateProductById(@PathVariable("id") long id){

    };
}
