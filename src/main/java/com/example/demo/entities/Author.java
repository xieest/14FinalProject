package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int authorId;

    @Column(name = "author_first_name")
    private String authorFirstName;

    @Column(name = "author_last_name")
    private String authorLastName;

    @Column(length = 500, name = "author_biography")
    private String authorBiography;

    @Column(name = "author_publisher")
    private String authorPublisher;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();

}
