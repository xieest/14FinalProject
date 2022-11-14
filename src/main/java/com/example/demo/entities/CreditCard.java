package com.example.demo.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Credit_Cards")
public class CreditCard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int card_id;

    @Column(name = "card_number", nullable = false, unique = true)
    private long cardNumber;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user")
    private User user;

}
