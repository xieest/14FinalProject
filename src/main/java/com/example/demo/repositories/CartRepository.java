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


    default Cart addToCart(Book book){
        Cart item = new Cart(book.getBookISBN(),book.getBookName(),book.getBookPrice());
        return item;
    }

    long deleteByBookISBN(long ISBN);
}