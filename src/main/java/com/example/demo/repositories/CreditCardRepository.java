package com.example.demo.repositories;

import com.example.demo.entities.CreditCard;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

    default boolean create(long creditCardNumber, User user) {
        for (CreditCard creditCard : findByUser(user)) {
            // if the credit card already exists, return true but don't add it again.
            if (creditCard.getCardNumber() == creditCardNumber) {
                return  true;
            }
        }
        if(!findByCardNumber(creditCardNumber).isEmpty()) {
            return false;
        }
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(creditCardNumber);
        creditCard.setUser(user);
        save(creditCard);
        return true;
    }

    Collection<CreditCard> findByUser(User user);

    Collection<CreditCard> findByCardNumber(long cardNumber);
}