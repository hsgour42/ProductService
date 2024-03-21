package com.example.productservice.models;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
//    @GeneratedValue(generator = "uuid_generator")
//    @GenericGenerator(name = "uuid_generator",strategy = "uuid2")
//    @Column(name = "id",columnDefinition = "binary(16)",nullable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
