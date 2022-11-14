package com.example.demo.repositories;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

// The repository annotation and the existing JpaRepository class comes with powerful, easy-to-implement tools that helps us easily create methods to retrieve, add, update and delete things on our database
@Repository
@Transactional
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    // The existing framework is robust; simply naming the method 'findAllByBook' allows Spring / JpaRepository to intuit how the method should work.
    List<Rating> findAllByBook(Book book);

    Rating save(Rating rating);

    Rating findByRatingId(int id);

}
