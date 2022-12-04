package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.Cart;
import com.example.demo.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository CartRepository;

    public Cart addToCartByName(Book book){
        try {
            Cart cart = CartRepository.addToCart(book);
            CartRepository.save(cart);
            return cart;
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<Cart> seeCart(){
        return CartRepository.findAll();
    }

    @Transactional
    public void removeBookByISBN(long ISBN){
        try{
            long deleteBook = CartRepository.deleteByBookISBN(ISBN);
            assertThat(deleteBook).isEqualTo(1);
        }   catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
