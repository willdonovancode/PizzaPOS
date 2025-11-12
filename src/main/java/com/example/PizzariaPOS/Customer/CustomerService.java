package com.example.PizzariaPOS.Customer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


//    public List<Customer> getCustomerByFirstName(String firstName) {
//        return customerRepository.findAll().stream()
//                .filter(customer -> customer.getFirst_name().toLowerCase().contains(firstName.toLowerCase()))
//                .collect(Collectors.toList());
//    }

    public List<Customer> getCustomerByPhoneNumber(String number){
        return customerRepository.findAll().stream().filter(customer -> customer.getFirst_name().toLowerCase().contains(number.toLowerCase()))
               .collect(Collectors.toList());
    }

    public Customer addCustomer(Customer customer) {
        // IMPORTANT: hash password for encyrption! if we decide on that
        // customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
        return customer;
    }


    public Customer updateCustomer(Customer update) {
        //update by pk
        Optional<Customer> existingCustomer = customerRepository.findByPhonenumber(update.getPhonenumber());

        if (existingCustomer.isPresent()) {
            Customer customerToUpdate = existingCustomer.get();
            customerToUpdate.setAddress(update.getAddress());
            customerToUpdate.setCardnumber(update.getCardnumber());
            customerRepository.save(customerToUpdate);
            return customerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteCustomer(String phonenumber) {

        customerRepository.deleteByPhonenumber(phonenumber);
    }
}