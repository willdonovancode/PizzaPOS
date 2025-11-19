package com.example.PizzariaPOS.MenuItem;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MenuItem")
// MenuItem entity representing items in the pizzeria menu


public class MenuItem {
    @Id
    @Column(name="id",unique = true)
    private int id;

    private String name;
    private double price;
    private String category; // "Pizza", "Beverage"
    private String size; // "Small", "Large" (nullable)
    private String crust; // "Thin", "Deep Dish" (nullable)

    // Constructors
    public MenuItem() {}

    public MenuItem(int id,String name, double price, String category, String size, String crust) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.size = size;
        this.crust = crust;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

}
