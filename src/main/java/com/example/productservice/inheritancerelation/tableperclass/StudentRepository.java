package com.example.productservice.inheritancerelation.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tcp_studentRepository")
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Override
    Student save(Student student);
}
