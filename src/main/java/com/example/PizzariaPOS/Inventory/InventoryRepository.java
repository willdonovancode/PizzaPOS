package com.example.PizzariaPOS.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    //remove from inventory when order goes through
//    void deleteById(int id);
//
//    Optional<Inventory> findById(int id);
    Optional<Inventory> findByMenuItemId(int menuItemId);
}
