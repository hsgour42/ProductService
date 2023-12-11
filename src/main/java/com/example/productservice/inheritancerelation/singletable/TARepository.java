package com.example.productservice.inheritancerelation.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("s_taRepository")
public interface TARepository extends JpaRepository<Ta,Long> {
    @Override
    Ta save(Ta ta);
}
