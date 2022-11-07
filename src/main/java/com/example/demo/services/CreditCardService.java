package com.example.demo.services;
import com.example.demo.entities.CreditCard;
import com.example.demo.entities.User;
import com.example.demo.repositories.CreditCardRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    public Optional<List<Long>> listCreditCardsForUser(String userName) {
        return userRepository.findById(userName)
                .map(user -> creditCardRepository.findByUser(user).stream().map(CreditCard::getCardNumber).toList()); // this function is going to take in whatever map is passing in.
    }// optional is a way to wrap objects to see if they either exist or do not exist.

    public boolean createCreditCard(long creditCardNumber, String userName) {
        // optional is a way to wrap objects to see if they either exist or do not exist.
        return userRepository.findById(userName)
                .map(user -> creditCardRepository.create(creditCardNumber,user))
                .orElse(false);
        // map: if the user exists, insert the credit card. if the user does not exist, return false.
    }
}