package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User findByUsername(String username) {
        try {
            return userRepository.findByUserName(username);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }
}