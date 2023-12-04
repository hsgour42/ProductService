package com.example.productservice.thirdPartyClients.fakeStoreClient;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClientAdapter {
    private final RestTemplateBuilder restTemplateBuilder;

    private final String genericProductUrl = "https://fakestoreapi.com/products";
    private final String specificProductUrl = "https://fakestoreapi.com/products/{id}";




    @Autowired
    public FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public FakeStoreProductDto getProductById(long id) throws ProductNotFoundException {
        //RestTemplate --for calling api
        RestTemplate template = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                template.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist");
        }

        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getAllProduct() {
        RestTemplate template = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntities  =
                template.getForEntity(genericProductUrl, FakeStoreProductDto[].class);

        return List.of(responseEntities.getBody());
    }


    public FakeStoreProductDto deleteProductById(long id) {
        RestTemplate template = restTemplateBuilder.build();
        //extract internal method
        RequestCallback requestCallback = template.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                template.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = template.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(genericProductUrl,  genericProductDto , FakeStoreProductDto.class);
        return responseEntity.getBody();
    }


    public FakeStoreProductDto updateProductById(long id, GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductDto);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);

        return responseEntity.getBody();
    }

}
