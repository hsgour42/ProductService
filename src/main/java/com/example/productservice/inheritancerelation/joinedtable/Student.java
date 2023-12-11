package com.example.productservice.inheritancerelation.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_student")
@PrimaryKeyJoinColumn(name ="user_Id")
public class Student extends User {
    private double psp;
}
