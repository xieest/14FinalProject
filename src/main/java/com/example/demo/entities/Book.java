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
@Table(name = "Books")
public class Book implements Serializable {

    @Id
    @Column(name = "ISBN", nullable = false)
    private long bookISBN;

    @Column(name = "book_position")
    private int bookCataloguePosition;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_description")
    private String bookDescription;

    @Column(name = "book_price")
    private double bookPrice;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_genre")
    private String bookGenre;

    @Column(name = "book_publisher")
    private String bookPublisher;

    @Column(name = "book_year")
    private int bookYear;

    @Column(name = "books_sold")
    private int booksSold;

    @Column(name = "book_avg_rating")
    private Double bookAvgRating;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "author")
    private Author author;

    @ManyToMany(mappedBy = "books_in_cart")
    private Set<Cart> carts;

    @ManyToMany(mappedBy = "books_in_wishlist")
    private Set<Wishlist> wishlists = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private Set<Rating> ratings = new HashSet<>();

}
