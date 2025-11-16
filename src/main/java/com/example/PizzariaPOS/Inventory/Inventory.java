

package com.example.PizzariaPOS.Inventory;

import com.example.PizzariaPOS.MenuItem.MenuItem;
import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name="id", unique = true)
    private int id;


    @OneToOne(optional = false) // 'optional = false' means an Inventory item MUST be linked to a MenuItem
    @JoinColumn(name = "menu_item_id", referencedColumnName = "id", unique = true) // This creates a 'menu_item_id' column
    private MenuItem menuItem;


    private int quantity;

    // Constructors
    public Inventory() {}

    public Inventory(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.id = menuItem.getId();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addQuantity(int amount){
        if (amount<0){
            throw  new IllegalStateException("Amount must be non negative");
        }
        this.quantity+=amount;
    }
    public int removeQuantity(int amount){
        if (this.quantity-amount<0){
            throw  new IllegalStateException("Not enough in inventory");
        }
        this.quantity-=amount;
        return this.quantity;
    }
}