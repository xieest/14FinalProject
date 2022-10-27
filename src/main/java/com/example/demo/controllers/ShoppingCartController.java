package com.example.demo.controllers;


import com.example.demo.entities.Cart;
import com.example.demo.services.BookService;
import com.example.demo.services.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shopping_cart")
public class ShoppingCartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;


    @ApiOperation(value = "return all shopping carts from database")
    @GetMapping(value = {"/seeList"})
    public ResponseEntity<List<Cart>> getAllBooks(){
        return new ResponseEntity<>(cartService.seeCart(), HttpStatus.OK);
    }


//    @GetMapping("/test")
//    public String welcome(){
//        return "This is a test";
//    }

    // In order for it to work,
    // all elements of the book entity must be filled including the book_avg_rating
    @ApiOperation(value = "save new shopping cart to the database")
    @PostMapping(value = {"/saveToCart"})
    public ResponseEntity<Cart> add(@RequestParam String bookName){
        return new ResponseEntity<>(cartService.addToCartByName(bookService.findByBookName(bookName)), HttpStatus.CREATED);
    }


    // In progress
    @ApiOperation(value = "remove book from database")
    @DeleteMapping(value = {"/remove"})
    public ResponseEntity<Void> removeBooks(@RequestParam String bookName){
        cartService.removeBookByName(bookName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
