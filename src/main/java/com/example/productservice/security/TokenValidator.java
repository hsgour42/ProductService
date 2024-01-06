package com.example.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator {
//    RestTemplateBuilder restTemplateBuilder;
//
//    public TokenValidator(RestTemplateBuilder restTemplateBuilder){
//        this.restTemplateBuilder = restTemplateBuilder;
//    }
//
//    /**
//     * This method should call the UserService to validate the token
//     * @param token
//     * @return JWTObject
//     */
//    public Optional<JWTObject> validateToken(String token){
//        RestTemplate template = restTemplateBuilder.build();
//        //template.getForEntity("http://localhost:8080/auth/signin" ,)
//        return Optional.empty();
//    }
}
