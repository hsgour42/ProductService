package com.example.productservice.inheritancerelation.tableperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_ta")
public class Ta extends User {
    private String ta_session;
}
