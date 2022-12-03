package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


/* The rating entity. Contains a primary key (rating_id) which is an ascending integer value auto-generated if not provided, as well as
many-to-one relationships to 'user' and 'book' entities. (Users may have more than one rating, as can books, but a rating cannot be for more than one user and/or book)

 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
@Entity
@Table(name = "Ratings")
public class Rating implements java.io.Serializable, Comparable<Rating>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int ratingId;

    @Column(nullable = false)
    private int rating;

    @Column
    private String comment;

    @Column
    private String datestamp;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "book")
    private Book book;

    // This method override exists so that we can easily sort the ratings by their integer value in the service or controller classes
    @Override
    public int compareTo(Rating rating1) {
        int compare = (rating1).getRating();
        return compare - this.rating;
    }
}
