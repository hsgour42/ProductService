package com.example.productservice.models;

import com.example.productservice.dtos.GenericProductDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    private int inventoryCount;


    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;

    @OneToOne(optional = false ,cascade = {CascadeType.REMOVE}) // auto delete the reference object
    @JoinColumn(nullable = false)
    private Price price;


    public GenericProductDto from(Product product){
        GenericProductDto genericProductDto = new GenericProductDto();


        genericProductDto.setTitle(product.getTitle());
        //genericProductDto.setPrice(product.getPrice());
        //genericProductDto.setCategory(product.getCategory());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setImage(product.getImage());
        return genericProductDto;
    }


}

