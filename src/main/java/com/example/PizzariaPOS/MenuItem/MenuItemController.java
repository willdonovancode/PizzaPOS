package com.example.PizzariaPOS.MenuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="api/v1/MenuItem")
public class MenuItemController {
    private final MenuItemService service;

    @Autowired
    public MenuItemController(MenuItemService service){
        this.service=service;
    }

    @GetMapping
    public List<MenuItem>getMenuItems(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category
    ){
        if(name!=null){
            return service.getMenuItemByName(name);
        }
        else if(category!=null){
            return service.getMenuItemByCategory(category);
        }
        else{
            return service.getMenuItems();
        }

    }
    //adding menuitems
    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem item){
        MenuItem createdItem=service.addMenuItem(item);
        return new ResponseEntity<>(createdItem,HttpStatus.CREATED);
    }
    //updating
    @PutMapping
    public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem item){
        MenuItem result = service.updateMenuitem(item);
        if (result!=null){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //deleting
    @DeleteMapping("/{MenuItemName}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable String itemName){
        service.deleteMenuItem(itemName);
        return new ResponseEntity<>("Player Deleted Successfully",HttpStatus.OK);
    }
}
