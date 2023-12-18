package com.example.productservice.controllers;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.models.Price;
import com.example.productservice.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)        //it won't initialize unnecessary dependency
public class ProductControllerWebMvcTest {

    @MockBean
    @Qualifier("fakeStoreProductServiceImpl")
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;        //just like make api call in real world

    @Inject
    private ObjectMapper objectMapper; //use for convert object to json

    @Test
    void testGetAllProductsReturnsEmptyList() throws Exception {
        when(productService.getAllProduct())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }

    @Test
    void testGetAllProductsReturnsValidList() throws Exception {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());

        when(productService.getAllProduct())
                .thenReturn(genericProductDtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
    }

    @Test
    void testCreateProductApi() throws Exception {
        GenericProductDto productDto = new GenericProductDto();
        productDto.setImage("macbook.jpg");
        productDto.setDescription("fasted laptop ever");
        productDto.setTitle("macbook");
        productDto.setPrice(new Price("INR" , 2000));
        GenericProductDto outputProductDto = new GenericProductDto();
        outputProductDto.setCategory(productDto.getCategory());
        outputProductDto.setId(UUID.randomUUID());
        outputProductDto.setDescription(productDto.getDescription());
        outputProductDto.setImage(productDto.getImage());
        outputProductDto.setPrice(productDto.getPrice());
        outputProductDto.setTitle(productDto.getTitle());

        when(productService.createProduct(any()))
                .thenReturn(outputProductDto);

        double expectedPrice = 2000;
        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto))
        )
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(outputProductDto)))
                .andExpect(jsonPath("$.title", is("macbook") ))
                .andExpect(jsonPath("$.price.value", is(expectedPrice) ));

    }

}
