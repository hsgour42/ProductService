package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.security.JWTObject;
import com.example.productservice.security.TokenValidator;
import com.example.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

//@Primary  //Default set for service if more then one bean is available as well as @Qualifier override the @Primary
@Service() //define the name for further use like use in controller
@Qualifier("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private final FakeStoreClient fakeStoreClient;
    private final TokenValidator tokenValidator;

    //Redis
    private HashOperations hashOperations;

    @Autowired
    FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient, TokenValidator tokenValidator,RedisTemplate redisTemplate){
        this.fakeStoreClient = fakeStoreClient;
        this.tokenValidator = tokenValidator;
        this.hashOperations = redisTemplate.opsForHash();

    }

    @Override
    public GenericProductDto getProductById(long id) throws ProductNotFoundException {
        //RestTemplate --for calling api
//        Optional<JWTObject> jwtObjectOptional = tokenValidator.validateToken(authToken);
//
//        if(jwtObjectOptional.isEmpty()){
//            //Token is not valid
//            //Reject the request
//            return null;
//        }
//
//         JWTObject jwtObject = jwtObjectOptional.get();
//         String emailJwt = jwtObject.getEmail();
//         UUID userIdJwt = jwtObject.getUserId();

         //Check conditions or set some rules here


        FakeStoreProductDto fakeStoreProductDto = null;
        fakeStoreProductDto = (FakeStoreProductDto) hashOperations.get("Product",id);

        if(fakeStoreProductDto == null){
            fakeStoreProductDto = fakeStoreClient.getProductById(id);
            hashOperations.put("Product",id,fakeStoreProductDto);
        }
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
        Price price = new Price("INR",fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());

       // genericProductDto.setCategory(category);
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
     //   genericProductDto.setPrice(price);
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }
}
