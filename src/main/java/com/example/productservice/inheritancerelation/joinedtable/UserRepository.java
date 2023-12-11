package com.example.productservice.inheritancerelation.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    User save(User user);
}
