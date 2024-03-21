package com.example.productservice.controllers;


import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.dtos.SearchRequestDto;
import com.example.productservice.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private  SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService){
         this.searchService = searchService;
    }

    @PostMapping
    public List<GenericProductDto> searchProducts(@RequestBody SearchRequestDto searchRequestDto){
        return searchService.searchProducts(
                searchRequestDto.getQuery() ,
                searchRequestDto.getPageNumber(),
                searchRequestDto.getItemsPerPage(),
                searchRequestDto.getSortParam()

        );
    }

//    @PostMapping
//    public Page<GenericProductDto> searchProducts(@RequestBody SearchRequestDto searchRequestDto){
//        List<GenericProductDto>  genericProductDtoList = searchService.searchProducts(
//                searchRequestDto.getQuery() ,
//                searchRequestDto.getPageNumber(),
//                searchRequestDto.getItemsPerPage()
//        );
//
//        Page<GenericProductDto> genericProductDtoPage = new PageImpl<>(genericProductDtoList);
//        return genericProductDtoPage;
//    }

}
