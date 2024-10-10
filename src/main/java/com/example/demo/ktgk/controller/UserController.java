package com.example.demo.ktgk.controller;
import com.example.demo.ktgk.model.Users;
import com.example.demo.ktgk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET ALL USERS
    @GetMapping
    @ResponseBody
    public List<Users> getUserList() {
        return userService.findAll();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") int userId) {
        Users user = userService.findById(userId);
        if (user != null) {
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).body(null);
    }

    // CREATE NEW USER
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        userService.save(user);
        return ResponseEntity.status(201).body(user);
    }

    // UPDATE USER BY ID
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") int userId, @RequestBody Users updateUser) {
        Users user = userService.findById(userId);
        if (user != null) {
            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            user.setPhoneNumber(updateUser.getPhoneNumber());
            user.setAddress(updateUser.getAddress());
            user.setCity(updateUser.getCity());
            user.setCountry(updateUser.getCountry());
            user.setPostalCode(updateUser.getPostalCode());
            userService.save(user);
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).body(null);
    }

    // DELETE USER BY ID
    @DeleteMapping("/{id}")
    @ResponseBody
    public List<Users> removeUserById(@PathVariable("id") int userId) {
        userService.delete(userId);
        return userService.findAll();
    }
}