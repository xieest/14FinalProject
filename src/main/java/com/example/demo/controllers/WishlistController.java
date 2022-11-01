package com.example.demo.controllers;


import com.example.demo.entities.Book;
import com.example.demo.entities.User;
import com.example.demo.entities.Wishlist;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import com.example.demo.services.WishlistService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/wishlists")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @ApiOperation(value = "save new wishlist to the database")
    @PostMapping(value = "/saveWishlist")
    public ResponseEntity<Wishlist> saveWishlist(@RequestBody Wishlist wishlist) {
        return new ResponseEntity<>(wishlistService.saveWishlist(wishlist), HttpStatus.CREATED);
    }
    /*
    @ApiOperation(value = "save new book to wishlist")
    @PostMapping(value = {"", "/"})
    public ResponseEntity<Wishlist> saveWishlist(@RequestBody Wishlist wishlist) {
        return new ResponseEntity<>(wishlistService.saveWishlist(wishlist), HttpStatus.CREATED);
    }
    */

    @ApiOperation(value = "return all wishlists from database")
    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Wishlist>> getAllWishlists(){
        return new ResponseEntity<>(wishlistService.findAll(), HttpStatus.OK);
    }


}
