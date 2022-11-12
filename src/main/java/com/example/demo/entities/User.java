package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Users")
public class User implements java.io.Serializable{
    @Id
    //May want to add an email constraint, as these strings all have to be valid emails
    @Column(name = "username", unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "home_address")
    private String homeAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Wishlist> wishlists = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<CreditCard> creditCards = new HashSet<>();

    @OneToOne(fetch=FetchType.LAZY, mappedBy = "user")
    private Cart cart;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Rating> ratings = new HashSet<>();
}
