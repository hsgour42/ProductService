package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Primary  //Default set for service if more then one bean is available as well as @Qualifier override the @Primary
@Service("fakeStoreProductServiceImpl") //define the name for further use like use in controller
public class FakeStoreProductServiceImpl implements ProductService{

    private final FakeStoreClient fakeStoreClient;

    @Autowired
    FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public GenericProductDto getProductById(long id) throws ProductNotFoundException {
        //RestTemplate --for calling api
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.getProductById(id);
        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public List<GenericProductDto> getAllProduct() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProduct();
        List<GenericProductDto> result = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos ){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public GenericProductDto deleteProductById(long id) {
        FakeStoreProductDto fakeStoreProductDto =  fakeStoreClient.deleteProductById(id);
        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.createProduct(genericProductDto);
        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto updateProductById(long id, GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.updateProductById(id,genericProductDto);
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
