package com.example.productservice.inheritancerelation.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("s_userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    User save(User user);
}
