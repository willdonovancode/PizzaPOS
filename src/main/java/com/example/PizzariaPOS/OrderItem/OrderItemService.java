package com.example.PizzariaPOS.OrderItem;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    // Get all order items
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    // Get all items for a specific order
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }


    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Update an order item
    public OrderItem updateOrderItem(int id, OrderItem itemDetails) {
        Optional<OrderItem> optionalItem = orderItemRepository.findById(id);

        if (optionalItem.isPresent()) {
            OrderItem existingItem = optionalItem.get();
            existingItem.setQuantity(itemDetails.getQuantity());


            return orderItemRepository.save(existingItem);
        }
        return null; // Or throw an exception
    }

    // Delete an item from an order
    @Transactional
    public void deleteOrderItem(int id) {
        orderItemRepository.deleteById(id);
    }
}