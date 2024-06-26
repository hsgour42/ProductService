package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class FakeStoreProductDto implements Serializable {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
