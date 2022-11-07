package com.example.demo.controllers;


import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
//@RequestMapping(value = "/books")
public class BookController {
//updated
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/message")
    public String getMessage(){
        return "Hello I'm from the controller";
    }
/* beginning of xieest original code
    @ApiOperation(value = "save new book to the database")
    @PostMapping(value = {"", "/"})
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @ApiOperation(value = "save new rating for a book")
    @PostMapping("")
    public ResponseEntity<Book> saveRating(@RequestBody Rating rating){
        return new ResponseEntity<>(bookService.addRating(rating), HttpStatus.CREATED);
    }

    @ApiOperation(value = "return all books from database")
    @GetMapping(value = {"/allBooks"})
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "return a book from database by its isbn")
    @GetMapping("/{bookISBN}")
    public ResponseEntity<Book> findBookByBookISBN(@PathVariable long bookISBN){
        return new ResponseEntity<>(bookService.findByBookISBN(bookISBN), HttpStatus.OK);
    }

    @ApiOperation(value = "update an existing book by its id")
    @PutMapping("/{bookISBN}")
    public ResponseEntity<Book> updateBook(@PathVariable Book book) {
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    @ApiOperation(value = "remove an existing book from database by its id")
    @DeleteMapping("/{bookISBN}")
    public ResponseEntity<Void> deleteBook(@PathVariable long bookISBN){
        bookService.removeBook(bookISBN);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
*/
}