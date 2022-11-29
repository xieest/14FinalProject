package com.example.demo.repositories;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.entities.Wishlist;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    //not ready
   // List<Wishlist> findAll();
    List<Wishlist> findAllByUser(User user);

    Wishlist save(Wishlist wishlist);
}
