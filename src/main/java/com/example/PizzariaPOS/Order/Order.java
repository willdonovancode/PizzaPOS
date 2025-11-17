package com.example.PizzariaPOS.Order;


import com.example.PizzariaPOS.Customer.Customer;
import com.example.PizzariaPOS.OrderItem.OrderItem;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Link to the customer who made the order
    @ManyToOne
    @JoinColumn(name = "customer_phone_number", referencedColumnName = "phonenumber")
    private Customer customer;

    // List of items in this order
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    //we use a set here instead of an arraylist because the orderItem class has a field called quantity
    //if we didnt have that we could have just used array list
    private Set<OrderItem> items = new HashSet<>();

    private LocalDateTime timestamp;
    private double totalCost;
    private String paymentMethod; // "Card", "Cash"


    // Constructors
    public Order() {
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }



    // Helper method to add items and set the back-reference
    public void addItem(OrderItem item) {
        items.add(item);
        item.setOrder(this);
    }
}
