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

    public List<Rating> findAll(){

        return ratingRepository.findAll();

    }

    public List<Rating> findAllByBook(Book book) {
        try {
            return ratingRepository.findAllByBook(book);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public List<Rating> findAllByUser(User user) {
        try {
            return ratingRepository.findAllByUser(user);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public Rating saveRating(Rating inputtedRating) {
        try {
            Rating rating = new Rating();
            BeanUtils.copyProperties(inputtedRating, rating); // instead of using many getters and setters; only works if inputtedBook and book has exact same variable names
            this.ratingRepository.save(rating);
            System.out.println("Book saved successfully");
            return rating;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}