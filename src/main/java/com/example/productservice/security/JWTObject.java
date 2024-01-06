package com.example.productservice.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class JWTObject {
    //This is kind of dto object
    private String email;
    private long userId;
    private Date expiryAt;
    private Date createdAt;
    private List<Role> roles;
}
