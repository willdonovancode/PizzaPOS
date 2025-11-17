package com.example.PizzariaPOS.Order;

import com.example.PizzariaPOS.OrderItem.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get a single order by its ID
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // Get all orders for a specific customer
    public List<Order> getOrdersByCustomer(String phonenumber) {
        return orderRepository.findByCustomerPhonenumber(phonenumber);
    }

    @Transactional
    public Order addOrder(Order order) {
        double total = 0.0;

        // Loop through the items sent from the frontend
        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {

                item.setOrder(order);

                // Calculate total cost
                // This assumes the frontend also sent the MenuItem with its price
                if (item.getMenuItem() != null) {

                    total += item.getMenuItem().getPrice() * item.getQuantity();
                }
            }
        }

        order.setTotalCost(total);
        order.setTimestamp(LocalDateTime.now()); // get current time

        return orderRepository.save(order);
    }


    @Transactional
    public Order updateOrder(Integer id, Order orderDetails) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            existingOrder.setPaymentMethod(orderDetails.getPaymentMethod());

            return orderRepository.save(existingOrder);
        }
        return null;
    }

    // Delete an order
    @Transactional
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}