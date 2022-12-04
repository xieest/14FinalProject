package com.example.demo.entities;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @Column(name = "ISBN", nullable = false)
    private long bookISBN;

    @Column(name = "book_name", nullable = false)
    private String name;

    @Column(name = "book_price", nullable = false)
    private double price;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "cart_user",
            joinColumns = @JoinColumn(name = "cart_isbn"),
            inverseJoinColumns = @JoinColumn(name = "user_username"))
    private User user;

    public Cart(long bookISBN, String bookName, double bookPrice) {
        this.bookISBN = bookISBN;
        this.name = bookName;
        this.price = bookPrice;
    }

}
