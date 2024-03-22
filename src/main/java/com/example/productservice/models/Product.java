package com.example.productservice.models;

import com.example.productservice.dtos.GenericProductDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

//@Document(indexName = "product")    //for elastic search
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





}

