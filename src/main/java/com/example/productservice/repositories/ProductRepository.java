package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product , UUID> {

    @Query(value = "select * from product" , nativeQuery = true)
    List<Product> findAll();
}
