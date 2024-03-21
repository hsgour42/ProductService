package com.example.productservice.controllers;


import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.security.JWTObject;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    //@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
    @GetMapping("/{id}")
    public GenericProductDto getProductById( @PathVariable("id") long id) throws ProductNotFoundException {
        //System.out.println(authToken);
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
        return productService.updateProductById(id,genericProductDto);
    };

    //if we have 5 type of exception we will end up with five type of method
    //so we introduce @ControllerAdvice

//    @ExceptionHandler(ProductNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//           ExceptionDto exceptionDto = ExceptionDto.
//                builder().
//                message(productNotFoundException.getMessage()).
//                httpStatus(HttpStatus.NOT_FOUND).
//                build();
//           return exceptionDto;
//    }

}
