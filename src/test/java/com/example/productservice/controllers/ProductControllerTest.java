package com.example.productservice.controllers;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.services.ProductService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest     //this will run and initiate all dependency every time where as @WebMvcTest initiate required dependency only
public class ProductControllerTest {

//    @Inject
//    private ProductController productController;
//
//
//    @MockBean
//    @Qualifier("fakeStoreProductServiceImpl")
//    private ProductService productService;
//
//    @Captor
//    private ArgumentCaptor<Long> argumentCaptor;
//
//
//
//    @Test
//    @DisplayName("One Plus One is Two")
//    void testOnePlusOneIsTwoOrNot(){
//        int value = 2;
//        Assertions.assertEquals(2  , value , "One Plus One Should be 2");
//    }
//
//    @Test
//    void testGetProductByIdNegativeTC() throws ProductNotFoundException {
//        when(productService.getProductById(1000L))
//                .thenThrow(ProductNotFoundException.class);
//        Assertions.assertThrows(ProductNotFoundException.class , () -> productController.getProductById(1000));
//        //(expectation , runMethod() with lambda expression)
//    }
//
//    @Test
//    void testGetProductByIdMocking() throws ProductNotFoundException {
//
//        //Case 1: any will work as any generic value
//        GenericProductDto productDto = new GenericProductDto();
//        when(productService.getProductById(any(Long.class)))
//                .thenReturn(productDto);
//
//        Assertions.assertEquals(productDto , productController.getProductById(1000L));
//
//        //Case 2:
//        //when(productService.getProductById(100L)).thenReturn(null);
//        //Assertions.assertNull(productController.getProductById(100L));
//    }
//
//    @Test
//    void testGetProductByIdExceptionMocking() throws ProductNotFoundException {
//        when(productService.getProductById(1L))
//                .thenThrow(ProductNotFoundException.class);
//
//        Assertions.assertThrows(ProductNotFoundException.class , () -> productController.getProductById(1L));
//    }
//
//    @Test
//    @DisplayName("Test Product Controller Calls Product Service With Same ProductId As Input")
//    void testIfSameInput() throws ProductNotFoundException {
//        long id = 100L;
//
//        productController.getProductById(id);
//
//        verify(productService).getProductById(argumentCaptor.capture());
//        Assertions.assertEquals(id, argumentCaptor.getValue());
//    }

}
