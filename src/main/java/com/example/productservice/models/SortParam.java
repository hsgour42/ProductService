package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParam {
    private String sortParamName;
    private String sortType;    //ASC or DESC
}
