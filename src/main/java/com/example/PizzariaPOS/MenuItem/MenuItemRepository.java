package com.example.PizzariaPOS.MenuItem;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
//import java.util.Optional;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {
    void deleteByName(String menuItemName);

    Optional<MenuItem> findByName(String name);
}
