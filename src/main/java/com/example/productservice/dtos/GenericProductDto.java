package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.models.Product;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericProductDto {
    private long id;
    private String title;
    private Price price;
    private Category category;
    private String description;
    private String image;
}
