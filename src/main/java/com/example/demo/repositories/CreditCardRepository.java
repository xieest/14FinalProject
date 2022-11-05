package com.example.demo.repositories;

import com.example.demo.entities.CreditCard;
import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

    default boolean create(long creditCardNumber, User user) {
        for (CreditCard creditCard : findCreditCardsForUser(user)) {
            // if the credit card already exists, return true but don't add it again.
            if (creditCard.getCardNumber() == creditCardNumber) {
                return  true;
            }
        }
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(creditCardNumber);
        creditCard.setUser(user);
        save(creditCard);
        return true;
    }

    List<CreditCard> findCreditCardsForUser(User user);
}