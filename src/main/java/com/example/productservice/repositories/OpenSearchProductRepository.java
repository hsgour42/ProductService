package com.example.productservice.repositories;

import com.example.productservice.models.Product;

import org.springframework.data.domain.Pageable;



import java.util.List;
import java.util.Optional;



public interface OpenSearchProductRepository  {
    List<Product> findAllByTitle(String title);


    Optional<Product> findById(Long productId);

    Product save(Product product);

    List<Product> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);
}


