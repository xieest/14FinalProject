package com.example.demo.controllers;


import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import com.example.demo.services.RatingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @ApiOperation(value = "save new rating to the database")
    @PostMapping(value = {"", "/"})
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.saveRating(rating), HttpStatus.CREATED);
    }

    @ApiOperation(value = "return all ratings from database")
    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Rating>> getAllRatings(){
        return new ResponseEntity<>(ratingService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "return all ratings for an individual book")
    @GetMapping("/{bookISBN}")
    public ResponseEntity<List<Rating>> findRatingsByBook(@PathVariable Book book){
        return new ResponseEntity<>(ratingService.findAllByBook(book), HttpStatus.OK);
    }

    @ApiOperation(value = "return all ratings for an individual user")
    @GetMapping("/{username}")
    public ResponseEntity<List<Rating>> findRatingsByUser(@PathVariable User user){
        return new ResponseEntity<>(ratingService.findAllByUser(user), HttpStatus.OK);
    }

}