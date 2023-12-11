package com.example.productservice.inheritancerelation.mappedsuperclass;


import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_ta")
public class Ta extends User{
    private String ta_session;
}
