package com.example.productservice.inheritancerelation.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_taRepository")
public interface TARepository extends JpaRepository<Ta,Long> {
    @Override
    Ta save(Ta ta);
}
