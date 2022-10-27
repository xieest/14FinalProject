package com.example.demo.repositories;

import com.example.demo.entities.Book;
import com.example.demo.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

    Cart findByBookISBN(long bookISBN);
    Cart findByName(String bookName);

    @Override
    List<Cart> findAll();

//    default Cart addToCartByISNB(long bookISBN){
//        Book book = findByBookISBN(bookISBN);
//        Cart cart = new Cart(book.getBookISBN(),book.getBookName(),book.getBookPrice());
//        return cart;
//    }


    default Cart addToCartByName(Book book){
        Cart item = new Cart(book.getBookISBN(),book.getBookName(),book.getBookPrice());
        return item;

    }

    void removeByBookISBN(long bookISBN);
    void deleteByName(String name);
}