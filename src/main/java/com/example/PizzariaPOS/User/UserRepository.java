package com.example.PizzariaPOS.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, String> {

    void deleteByPhonenumber(String phonenumber);
    Optional<User> findByPhonenumber(String phonenumber);
}