package com.example.demo.services;

import com.example.demo.entities.Author;
import com.example.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {

        return this.authorRepository.save(author);

    }

    public Author findByAuthorId(int id) {
        return this.authorRepository.findByAuthorId(id);
    }
}
