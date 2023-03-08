package com.cdvtc.ecommerce.repository;

import com.cdvtc.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByEmailAndPassword(String email, String password);

    @Query("from User user where user.name=:name or user.email=:name")
    User getUserByName(String name);
}
