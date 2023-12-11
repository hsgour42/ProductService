package com.example.productservice.inheritancerelation.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_studentRepository")
public interface StudentRepository extends JpaRepository<Student , Long> {
    @Override
    Student save(Student student);
}
