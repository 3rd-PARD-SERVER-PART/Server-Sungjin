package com.example.thirdseminar.user.repo;

import com.example.thirdseminar.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.PasswordAuthentication;


public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserEmail(String userEmail);
}
