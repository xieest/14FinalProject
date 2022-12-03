package com.example.demo.repositories;

import com.example.demo.entities.Book;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, String>{

    User findByUserName(String username);

}
