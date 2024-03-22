package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.OpenSearchProductRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service()
@Qualifier("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    SelfProductServiceImpl(
            ProductRepository productRepository

    ){
        this.productRepository = productRepository;

    }

    @Override
    public GenericProductDto getProductById(long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(UUID.fromString("72eb2aa0-b7aa-4e7b-af2b-7f876c3046ac"));
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product not available with given id");
        }

        Product product = optionalProduct.get();

        return GenericProductDto
                .builder()
                .description(product.getDescription())
                .image(product.getImage())
                .title(product.getTitle())
                //.price(product.getPrice())
                //.category(product.getCategory())
                .build();
    }

    @Override
    public List<GenericProductDto> getAllProduct() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Product product = new Product();
        product.setTitle(genericProductDto.getTitle());
        product.setDescription(genericProductDto.getDescription());
        product.setCategory(genericProductDto.getCategory());
        product.setImage(genericProductDto.getImage());
        product.setPrice(genericProductDto.getPrice());

        Product savedProduct = productRepository.save(product);

        return GenericProductDto.from(savedProduct);
    }

    @Override
    public GenericProductDto updateProductById(long id, GenericProductDto genericProductDto) {
        return null;
    }
}
