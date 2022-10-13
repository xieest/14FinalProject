package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Authors")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int author_id;

    @Column(name = "author_first_name", nullable = false)
    private String authorFirstName;

    @Column(name = "author_last_name", nullable = false)
    private String authorLastName;

    @Column(length = 500, name = "author_biography", nullable = false)
    private String authorBiography;

    @Column(name = "author_publisher", nullable = false)
    private String authorPublisher;

    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();

}
