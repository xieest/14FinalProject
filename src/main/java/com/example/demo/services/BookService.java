package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){

        return bookRepository.findAll();

    }

    public Book findByBookISBN(long bookISBN) {
        try {
            return bookRepository.findByBookISBN(bookISBN);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public Book saveBook(Book inputtedBook) {
        try {
            Book book = new Book();
            BeanUtils.copyProperties(inputtedBook, book); // instead of using many getters and setters; only works if inputtedBook and book has exact same variable names
            this.bookRepository.save(book);
            System.out.println("Book saved successfully");
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Book updateBook(Book book) {
        try {
            Book oldBook = bookRepository.findByBookISBN(book.getBookISBN());
            bookRepository.delete(oldBook);
            bookRepository.save(book);
            return book;
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public Book addRating(Rating inputtedRating) {
        try {

            Long bookISBN = inputtedRating.getBook().getBookISBN();
            Book book = bookRepository.addRatingByBookISBN(bookISBN, inputtedRating);
            System.out.println("Rating saved successfully");
            updateBook(book);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void removeBook(long bookISBN) {
        try {
            bookRepository.deleteByBookISBN(bookISBN);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}

