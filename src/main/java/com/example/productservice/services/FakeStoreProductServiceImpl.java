package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("fakeStoreProductServiceImpl") //define the name for further use like use in controller
public class FakeStoreProductServiceImpl implements ProductService{

    private final RestTemplateBuilder restTemplateBuilder;

    private final String genericProductUrl = "https://fakestoreapi.com/products";
    private final String specificProductUrl = "https://fakestoreapi.com/products/{id}";



    @Autowired
    FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductById(long id) throws ProductNotFoundException {
        //RestTemplate --for calling api
        RestTemplate template = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
          template.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist");
        }
        //convert FakeStoreProductDto to GenericProductDto before returning
        GenericProductDto genericProductDto = convertToGenericProductDto(responseEntity.getBody());

        return genericProductDto;
    }

    private GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        assert fakeStoreProductDto != null;
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProduct() {
        RestTemplate template = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntities  =
                template.getForEntity(genericProductUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntities.getBody());

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos ){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }

        return result;
    }

    @Override
    public GenericProductDto deleteProductById(long id) {
        RestTemplate template = restTemplateBuilder.build();
        //extract internal method
        RequestCallback requestCallback = template.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                template.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = template.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(genericProductUrl,  genericProductDto , FakeStoreProductDto.class);

        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto updateProductById(long id, GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductDto);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);

        return convertToGenericProductDto(responseEntity.getBody());
    }




}
