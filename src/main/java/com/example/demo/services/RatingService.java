package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.RatingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private BookRepository bookRepository;

    // A simple method that returns all ratings in our database, for all books and users
    public List<Rating> findAll(){

        return ratingRepository.findAll();

    }

    public Rating findByRatingId(int ratingId) {
        return ratingRepository.findByRatingId(ratingId);
    }

    // Here we rely on the bookRepository to return us a Book object that is then used to find all ratings associated with the book
    public List<Rating> findAllByBook(long bookISBN) {
        try {
            return ratingRepository.findAllByBook(bookRepository.findByBookISBN(bookISBN));
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    // Once a valid rating is provided to this method, it saves the rating in our database
    public Rating saveRating(Rating inputtedRating) {
        try {
            Rating rating = new Rating();
            BeanUtils.copyProperties(inputtedRating, rating); // instead of using many getters and setters; only works if inputtedBook and book has exact same variable names
            this.ratingRepository.save(rating);
            System.out.println("Rating saved successfully");
            return rating;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
