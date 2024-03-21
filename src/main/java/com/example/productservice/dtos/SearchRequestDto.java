package com.example.productservice.dtos;


import com.example.productservice.models.SortParam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDto {
    private String query;
    private int pageNumber;
    private int itemsPerPage;
    private List<SortParam> sortParam;
}
