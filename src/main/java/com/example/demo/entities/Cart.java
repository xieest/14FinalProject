package com.example.demo.entities;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Carts")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int cart_id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "books_cart",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "book_ISBN")
    )
    private Set<Book> books_in_cart = new HashSet<>();
}