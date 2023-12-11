package com.example.productservice.inheritancerelation.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    User  save(User user);
}
