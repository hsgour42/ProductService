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


    public static GenericProductDto from(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        //genericProductDto.setPrice(product.getPrice());
        genericProductDto.setImage(product.getImage());
        //genericProductDto.setId(product.getId());

        return genericProductDto;
    }
}

