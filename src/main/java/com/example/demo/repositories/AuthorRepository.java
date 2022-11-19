package com.example.demo.repositories;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author save(Author author);

    Author findByAuthorId (int id);
}
