package com.example.demo.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
@Entity
@Table(name = "Ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int rating_id;

    @Column(nullable = false)
    private int rating;

    @Column
    private String comment;

    @Column
    private Date datestamp;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book")
    private Book book;

}
