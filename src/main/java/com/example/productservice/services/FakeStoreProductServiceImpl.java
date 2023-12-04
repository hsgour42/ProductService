package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductServiceImpl") //define the name for further use like use in controller
public class FakeStoreProductServiceImpl implements ProductService{

    private final FakeStoreClientAdapter fakeStoreClientAdapter;

    @Autowired
    FakeStoreProductServiceImpl(FakeStoreClientAdapter fakeStoreClientAdapter){
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
    }

    @Override
    public GenericProductDto getProductById(long id) throws ProductNotFoundException {
        //RestTemplate --for calling api
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClientAdapter.getProductById(id);
        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public List<GenericProductDto> getAllProduct() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClientAdapter.getAllProduct();
        List<GenericProductDto> result = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos ){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public GenericProductDto deleteProductById(long id) {
        FakeStoreProductDto fakeStoreProductDto =  fakeStoreClientAdapter.deleteProductById(id);
        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClientAdapter.createProduct(genericProductDto);
        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto updateProductById(long id, GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClientAdapter.updateProductById(id,genericProductDto);
        return convertToGenericProductDto(fakeStoreProductDto);
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
}
