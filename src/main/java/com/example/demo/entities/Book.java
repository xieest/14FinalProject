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
@Table(name = "Books")
public class Book implements Serializable {

    @Id
    @Column(name = "ISBN", nullable = false)
    private long bookISBN;

    @Column(name = "book_position")
    private int bookCataloguePosition;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(length = 500, name = "book_description", nullable = false)
    private String bookDescription;

    @Column(name = "book_price", nullable = false)
    private double bookPrice;

    @Column(name = "book_author", nullable = false)
    private String bookAuthor;

    @Column(name = "book_genre", nullable = false)
    private String bookGenre;

    @Column(name = "book_publisher", nullable = false)
    private String bookPublisher;

    @Column(name = "book_year", nullable = false)
    private int bookYear;

    @Column(name = "books_sold", nullable = false)
    private int booksSold;

    @Column(name = "book_avg_rating")
    private double bookAvgRating;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author")
    private Author author;

//    @ManyToMany(mappedBy = "books_in_cart")
//    private Set<Cart> carts;

    @ManyToMany(mappedBy = "books_in_wishlist")
    private Set<Wishlist> wishlists = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private Set<Rating> ratings = new HashSet<>();

}
