package com.example.demo.controllers;


import com.example.demo.entities.Cart;
import com.example.demo.services.BookService;
import com.example.demo.services.CartService;
import com.sun.jdi.InvalidTypeException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shopping_cart/")
public class ShoppingCartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;


    @ApiOperation(value = "return all shopping carts from database")
    @GetMapping
    public ResponseEntity<List<Cart>> getAllBooks(){
        return new ResponseEntity<>(cartService.seeCart(), HttpStatus.OK);
    }

    // In order for it to work,
    // all elements of the book entity must be filled including the book_avg_rating
    @ApiOperation(value = "save new shopping cart to the database")
    @PostMapping(value = {"{ISBN}"})
    public String add(@PathVariable long ISBN){
        try {
            new ResponseEntity<>(cartService.addToCartByName(bookService.findByBookISBN(ISBN)), HttpStatus.CREATED);
            return ISBN + " added to cart";
        }catch (NullPointerException e){
            return "Something went wrong please check that you entered the right ISBN.";
        }catch (Exception e){
            return ISBN + " is not available";
        }
    }

    @ApiOperation(value = "remove book from database")
    @DeleteMapping(value = {"{ISBN}"})
    public String removeBooks(@PathVariable long ISBN) {
        try {
            cartService.removeBookByISBN(ISBN);
            return ISBN + " removed from cart";
        } catch (NullPointerException e) {
            return "Something went wrong please check that you entered the right ISBN.";
        } catch (Exception e) {
            return ISBN + " is not available";
        }
    }
}
