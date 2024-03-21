package com.example.productservice.services;


import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.models.Product;
import com.example.productservice.models.SortParam;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ProductRepository productRepository;

    @Autowired
    public SearchService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<GenericProductDto> searchProducts(String query , int pageNumber , int pageSize , List<SortParam> sortParams){
        Sort sort = null;
        if(sortParams.get(0).getSortType().equals("ASC")){
            sort = Sort.by(sortParams.get(0).getSortParamName()).ascending();
        }else{
            sort = Sort.by(sortParams.get(0).getSortParamName()).descending();
        }
        for(int i = 0 ; i < sortParams.size() ; i++){
            if(sortParams.get(i).getSortType().equals("ASC")){
                sort.and(Sort.by(sortParams.get(i).getSortParamName())).ascending();
            }else{
                sort.and(Sort.by(sortParams.get(i).getSortParamName())).descending();
            }
        }

        PageRequest pageRequest = PageRequest.of(pageNumber , pageSize , sort);



        List<Product> productList = productRepository.findAllByTitleContainingIgnoreCase(query , pageRequest);
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(Product product:productList){
                genericProductDtos.add(product.from(product));
        }
        return genericProductDtos;
    }
}
