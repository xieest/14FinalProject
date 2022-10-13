package com.example.demo.repositories;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByBookISBN(long bookISBN);

    default Set<Rating> findRatingsByBookISBN(long bookISBN) {
        Book book = findByBookISBN(bookISBN);
        return book.getRatings();
    }

    default Book addRatingByBookISBN(long bookISBN, Rating rating) {
        Book book = findByBookISBN(bookISBN);
        Set<Rating> allRatings = book.getRatings();
        allRatings.add(rating);
        book.setRatings(allRatings);
        return book;
    }

    void deleteByBookISBN(long bookISBN);
}
