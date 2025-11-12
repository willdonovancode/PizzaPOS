package com.example.PizzariaPOS.User;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

//business logic can update if needed like inverntory repots and shit

@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public List<User> getUserByPhone(String phonenumber){

        return userRepository.findByPhonenumber(phonenumber).stream().toList();
    }


    public User addUser(User user) {

        userRepository.save(user);
        return user;
    }


    public User updateUser(User update) {
        // Find the user by their phone number (the ID)
        Optional<User> existingUser = userRepository.findByPhonenumber(update.getPhonenumber());

        if (existingUser.isPresent()) {
            //the fields that are updating can add more
            User userToUpdate = existingUser.get();
            userToUpdate.setAddress(update.getAddress());
            userToUpdate.setManager(update.isManager());
            userToUpdate.setFirst_name(update.getFirst_name());
            userToUpdate.setLast_name(update.getLast_name());

            userRepository.save(userToUpdate);
            return userToUpdate;
        }
        return null; // User not found
    }

    @Transactional
    public void deleteUser(String phonenumber) {
        userRepository.deleteByPhonenumber(phonenumber);
    }
}