package com.example.productservice.inheritancerelation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "s_student")
@DiscriminatorValue(value = "2")
public class Student extends User {
    private double psp;
}
