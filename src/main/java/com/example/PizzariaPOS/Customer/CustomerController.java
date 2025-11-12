package com.example.PizzariaPOS.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Customer") // Using lowercase convention
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(
            @RequestParam(required = false) String phonenumber
    ) {
        if (phonenumber != null) {
            return customerService.getCustomerByPhoneNumber(phonenumber);
        } else {
            return customerService.getCustomers();
        }
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer result = customerService.updateCustomer(customer);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete by phone #
    @DeleteMapping("/{firstName}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String phonenumber) {
        customerService.deleteCustomer(phonenumber);
        return new ResponseEntity<>("Customer Deleted Successfully", HttpStatus.OK);
    }
}