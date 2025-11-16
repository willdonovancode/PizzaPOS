package com.example.PizzariaPOS.Inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository=inventoryRepository;
    }

    public List<Inventory> getInventory(){
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(int id){
        return inventoryRepository.findById(id);
    }
    public Inventory addItem(Inventory item){
        Optional <Inventory> existing = inventoryRepository.findById(item.getId());
        if (existing.isPresent()){
            throw new IllegalStateException("Item with id already in inventory");
        }
        inventoryRepository.save(item);
        return item;
    }
    public void removeFromInventory(int menuItemId, int amount_ordered){
        //when item is ordered it subtracts from inventory
        Optional<Inventory> existing = inventoryRepository.findByMenuItemId(menuItemId);
        if (existing.isEmpty()){
            throw new IllegalStateException("Item does not exist in inventory");
        }
        Inventory inventoryItem= existing.get();
        inventoryItem.removeQuantity(amount_ordered);
        inventoryRepository.save(inventoryItem);
    }
    public void resupply(int id, int amount){
        Optional<Inventory> existing = inventoryRepository.findByMenuItemId(id);
        if (existing.isEmpty()){
            throw new IllegalStateException("Item does not exist in inventory");
        }
        Inventory inventoryItem= existing.get();
        inventoryItem.addQuantity(amount);
        inventoryRepository.save(inventoryItem);
    }

}
