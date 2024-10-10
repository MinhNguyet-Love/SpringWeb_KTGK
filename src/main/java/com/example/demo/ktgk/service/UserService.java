package com.example.demo.ktgk.service;

import com.example.demo.ktgk.model.Users;
import com.example.demo.ktgk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public Users update(Users user) {
        return userRepository.save(user);
    }

    public void delete(int userId) {
        userRepository.deleteById(userId);
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}