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

//    public Cart saveShoppingCart(Cart inputtedShoppingCart) {
//        try {
//            long ISBN = inputtedShoppingCart.getBookISBN();
//            Cart shoppingCart = CartRepository.addToCartByISNB(ISBN);
////            BeanUtils.copyProperties(inputtedShoppingCart, shoppingCart);
//            this.CartRepository.save(shoppingCart);
//            System.out.println("Book added to cart");
////            updateShoppingCart(shoppingCart);
//            return shoppingCart;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }

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
