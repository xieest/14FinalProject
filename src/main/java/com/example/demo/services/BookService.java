package com.example.demo.services;

import com.example.demo.entities.Author;
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
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(bookList::add);
        return bookList;
    }

    public Book getBookByISBN(long isbn){
        Optional<Book> optionalBook = bookRepository.findById(isbn);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        return null;
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> findAllByAuthor(Author author) {
        try {
            return bookRepository.findAllByAuthor(author);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }
    public Book updateBook(Book book) {
        try {
            Book oldBook = getBookByISBN(book.getBookISBN());
            bookRepository.delete(oldBook);
            return bookRepository.save(book);

        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    /* //Ed code
    private List<Book> list = new ArrayList<>();
    public BookService(){
        System.out.println("Service Layer is created");
        list.add(new Book(9711161484100L, 1, "The SHRM Essential guide to Employment Law", "An easy guide to employment law", 12.33, "Steve Fleischer", "Education", "SHRM", 2021, 13045, 1));
        list.add(new Book(9722161484100L, 2, "Criminal Procedure", "A very easy guide to criminal procedure", 13.44, "Sean Samaha", "Legal help", "Wadsworth", 2020, 30000, 2));
        list.add(new Book(9783161484109L, 3, "Wuthering Heights", "Emily Bronte records the story of the passionate love between Catherine Earnshaw and the wild Heathcliff", 25, "Emily Bronte", "Fiction", "Penguin Classics", 1848, 3000, 3));
        list.add(new Book(9744161484100L, 4, "Nineteen Eightyfour", "Popular novel", 4.99, "George Orwell", "Fiction", "Signet Classics", 1984, 10000, 4));
    }
    // returns all books
    public List<Book> getAllBooks(){
        return list;
    }
    //returns books by isbn
    public Book getBook(long isbn){
        for(Book b : list){
            if(b.getBookISBN() == isbn){
                return b;
            }
        }
        return null;
    }
    // save a book
    public void saveBook(Book book){
        this.list.add(book);
    }
    // update book
    public void updateBook(Book book){
        for(Book b : list){
            if(b.getBookISBN() == book.getBookISBN()){
                b.setBookName(book.getBookName());
            }
        }
    }
    // remove a book
    public void removeBook(long isbn){
        list.remove(isbn);
    }
     */

    /* //xieest original code
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
*/
}