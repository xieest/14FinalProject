package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.Wishlist;
import com.example.demo.entities.User;
import com.example.demo.repositories.WishlistRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Wishlist> findAll(){

        return wishlistRepository.findAll();

    }
    /*
        public List<Wishlist> findAllByUser(User user) {
            try {
                return wishlistRepository.findAllByUser(user);
            } catch (NoSuchElementException e) {
                throw e;
            }
        }
      */
    public List<Wishlist> findAllByUser(User user) {
        try {
            return wishlistRepository.findAllByUser(user);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public Wishlist saveWishlist(Wishlist inputtedWishlist) {
        try {
            Wishlist wishlist = new Wishlist();
            BeanUtils.copyProperties(inputtedWishlist, wishlist); // instead of using many getters and setters; only works if inputtedBook and book has exact same variable names
            this.wishlistRepository.save(wishlist);
            System.out.println("Wishlist saved successfully");
            return wishlist;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
