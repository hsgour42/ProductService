package com.example.productservice.security;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@MappedSuperclass
@Getter
@Setter
public class BaseModel {
//    @Id
//    @GeneratedValue(generator = "uuid_generator")
//    @GenericGenerator(name = "uuid_generator" , strategy = "uuid2")
//    @Column(name ="id", columnDefinition = "binary(16)" , nullable = false , updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
}
