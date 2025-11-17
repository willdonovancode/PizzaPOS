//package com.example.PizzariaPOS.Order;
//
//
//import com.example.PizzariaPOS.Customer.Customer;
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name="Order")
//
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // Link to the customer who made the order
//    @ManyToOne
//    @JoinColumn(name = "customer_phone_number", referencedColumnName = "phone_number")
//    private Customer customer;
//
//    // List of items in this order
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    //private Set<OrderItem> items = new HashSet<>();
//
//    private LocalDateTime timestamp;
//    private double totalCost;
//    private String paymentMethod; // "Card", "Cash"
//    private String signature; // Can be null if cash
//
//    // Constructors
//    public Order() {
//        this.timestamp = LocalDateTime.now();
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Set<OrderItem> getItems() {
//        return items;
//    }
//
//    public void setItems(Set<OrderItem> items) {
//        this.items = items;
//    }
//
//    public LocalDateTime getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(LocalDateTime timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public double getTotalCost() {
//        return totalCost;
//    }
//
//    public void setTotalCost(double totalCost) {
//        this.totalCost = totalCost;
//    }
//
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//
//    public String getSignature() {
//        return signature;
//    }
//
//    public void setSignature(String signature) {
//        this.signature = signature;
//    }
//
//    // Helper method to add items and set the back-reference
//    public void addItem(OrderItem item) {
//        items.add(item);
//        item.setOrder(this);
//    }
//}
