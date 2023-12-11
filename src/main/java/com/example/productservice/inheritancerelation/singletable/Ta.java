package com.example.productservice.inheritancerelation.singletable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "s_ta")
@DiscriminatorValue(value = "1")
public class Ta extends User {
    private String ta_session;
}
