package com.example.PizzariaPOS.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/OrderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Get all items, or get items for a specific order
    // e.g., GET /api/v1/OrderItem
    // e.g., GET /api/v1/OrderItem?orderId=1
    @GetMapping
    public List<OrderItem> getOrderItems(
            @RequestParam(required = false) Integer orderId
    ) {
        if (orderId!=null) {
            return orderItemService.getOrderItemsByOrderId(orderId);
        } else {
            return orderItemService.getAllOrderItems();
        }
    }

    // Add a new order item
    // POST /api/v1/OrderItem
    @PostMapping
    public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem createdItem = orderItemService.addOrderItem(orderItem);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    // Update an existing order item's quantity
    // PUT /api/v1/OrderItem/5
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(
            @PathVariable int id,
            @RequestBody OrderItem orderItemDetails
    ) {
        OrderItem result = orderItemService.updateOrderItem(id, orderItemDetails);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an order item
    // DELETE /api/v1/OrderItem/5
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable int id) {
        orderItemService.deleteOrderItem(id);
        return new ResponseEntity<>("Order item deleted successfully", HttpStatus.OK);
    }
}