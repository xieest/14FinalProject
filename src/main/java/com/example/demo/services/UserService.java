package com.example.demo.services;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findById(username);
    }

    public boolean createUser(User user) {
        return userRepository.create(user);
    }

    public boolean updateUser(User user) {
        return userRepository.update(user);
    }



}