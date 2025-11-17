package com.example.PizzariaPOS.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping
    public List<Inventory> getInventory() {
        return inventoryService.getInventory();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") int id) {
        Optional<Inventory> inventory = inventoryService.getInventoryById(id);

        return inventory.map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Inventory> addInventoryItem(@RequestBody Inventory inventory) {
        try {
            Inventory newItem = inventoryService.addItem(inventory);
            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }


    @PutMapping(path = "/resupply")
    public ResponseEntity<String> resupplyInventory(@RequestBody ResupplyRequest request) {
        try {
            inventoryService.resupply(request.menuItemId, request.amount);
            return new ResponseEntity<>("Resupply successful", HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}


class ResupplyRequest {
    public int menuItemId;
    public int amount;
}