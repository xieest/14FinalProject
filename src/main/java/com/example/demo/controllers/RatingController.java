package com.example.demo.controllers;


import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import com.example.demo.services.RatingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping(value = "/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // The client must provide a rating object formatted correctly with all necessary fields. As long as the rating number is a valid integer (in our case between 1 and 5 inclusive) the rating is saved in our database
    // Otherwise the client is given a http response with a custom header that says the rating is invalid.

    @ApiOperation(value = "save new rating to the database")
    @PostMapping(value = {"", "/"})
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
            rating.setDatestamp(LocalDateTime.now().toString());
            if (rating.getRating() > 0 && rating.getRating() < 6) {
                return new ResponseEntity<>(ratingService.saveRating(rating), HttpStatus.CREATED);
            }
            String message = "Warning";
            String invalidResponse = "Invalid rating. Try again";
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set(message, invalidResponse);
            return new ResponseEntity<>(null, responseHeaders, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // This returns all ratings from the database.

    @ApiOperation(value = "return all ratings from database")
    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Rating>> getAllRatings(){

        return new ResponseEntity<>(ratingService.findAll(), HttpStatus.OK);
    }

    // This returns all ratings from the database sorted by rating value (highest to lowest)

    @GetMapping("/getRatingsSorted")
        public ResponseEntity<List<Rating>> getRatingsSorted() {
            List<Rating> sortedRatings = ratingService.findAll();

            Collections.sort(sortedRatings, Comparator.nullsLast(Comparator.naturalOrder()));

            return new ResponseEntity<>(sortedRatings, HttpStatus.OK);
    }

    // This returns the average rating for a specific book; the book ISBN needs to be provided in the URI

    @ApiOperation(value = "return average rating for an individual book")
    @GetMapping(value = {"/{bookISBN}/average"})
    public Double findAverageRatingByBook (@PathVariable long bookISBN) {
        List<Rating> ratings = ratingService.findAllByBook(bookISBN);
        List<Integer> ratingnumbers = new ArrayList<>();
        ratings.forEach(rating -> {
            ratingnumbers.add(rating.getRating());
        });
        OptionalDouble average = ratingnumbers
                .stream()
                .mapToDouble(a -> a)
                .average();
        return average.isPresent() ? average.getAsDouble() : null;
    }

    // This returns all ratings for a specific book; the book ISBN needs to be provided in the URI

    @ApiOperation(value = "return all ratings for an individual book")
    @GetMapping("/{bookISBN}")
    public ResponseEntity<List<Rating>> findRatingsByBook(@PathVariable long bookISBN){
        return new ResponseEntity<>(ratingService.findAllByBook(bookISBN), HttpStatus.OK);
    }

}