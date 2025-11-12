package com.example.PizzariaPOS.MenuItem;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//Service class handles all logic
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MenuItemService {
    private final MenuItemRepository itemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    public List<MenuItem> getMenuItems(){
        return itemRepository.findAll();
    }

    public List<MenuItem> getMenuItemByCategory(String category){
        return itemRepository.findAll().stream()
                .filter(MenuItem->category.equals(MenuItem.getCategory()))
                .collect(Collectors.toList());
    }
    public List<MenuItem> getMenuItemByName (String name){
        return itemRepository.findAll().stream()
                .filter(MenuItem->MenuItem.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public MenuItem addMenuItem(MenuItem item){
        itemRepository.save(item);
        return item;
    }

    public MenuItem updateMenuitem(MenuItem update){
        Optional<MenuItem> existingItem = itemRepository.findByName(update.getName());

        if (existingItem.isPresent()){
            MenuItem itemToUpdate = existingItem.get();
            itemToUpdate.setPrice(update.getPrice());
            itemRepository.save(itemToUpdate);
            return itemToUpdate;
        }
        return null;
    }
    @Transactional
    public void deleteMenuItem(String itemName){
        itemRepository.deleteByName(itemName);
    }
}
