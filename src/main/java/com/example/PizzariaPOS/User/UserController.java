package com.example.PizzariaPOS.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/User")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users, or get a specific user by phone number
    @GetMapping
    public List<User> getUsers(
            @RequestParam(required = false) String phonenumber
    ) {
        if (phonenumber != null && !phonenumber.isEmpty()) {
            return userService.getUserByPhone(phonenumber);
        } else {
            return userService.getUsers();
        }
    }

    // Add a new user (employee/manager)
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Update an existing user
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User result = userService.updateUser(user);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a user by their phone number
    @DeleteMapping("/{phonenumber}")
    public ResponseEntity<String> deleteUser(@PathVariable String phonenumber) {
        userService.deleteUser(phonenumber);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }
}