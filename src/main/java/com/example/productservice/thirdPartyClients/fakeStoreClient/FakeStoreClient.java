package com.example.productservice.thirdPartyClients.fakeStoreClient;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import lombok.Setter;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    private  RestTemplateBuilder restTemplateBuilder;
    private  String genericProductUrl;
    private  String specificProductUrl;




    @Autowired
    public FakeStoreClient(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${fakestore.api.url}" ) String fakeStoreUrl,
            @Value("${fakestore.api.paths.products}" ) String pathForProducts
    ) {
        this.restTemplateBuilder = restTemplateBuilder;
        genericProductUrl = fakeStoreUrl + pathForProducts  ;
        specificProductUrl = fakeStoreUrl + pathForProducts  + "/{id}";
    }


    public FakeStoreProductDto getProductById(long id) throws ProductNotFoundException {
        //RestTemplate --for calling api
        RestTemplate template = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                template.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);

        System.out.println("Himanshu");
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
