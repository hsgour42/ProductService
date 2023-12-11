package com.example.productservice.inheritancerelation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "s_mentors")
@DiscriminatorValue("3")
public class Mentor extends User {
    private double avgRating;
}
