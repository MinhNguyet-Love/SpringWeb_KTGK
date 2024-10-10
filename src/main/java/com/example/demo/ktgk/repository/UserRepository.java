package com.example.demo.ktgk.repository;

import com.example.demo.ktgk.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
}