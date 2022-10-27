package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.Cart;
import com.example.demo.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//            String name = inputtedShoppingCart.getName();

            Cart cart = CartRepository.addToCartByName(book);
            CartRepository.save(cart);
            System.out.println("Book added to cart");
            return cart;
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<Cart> seeCart(){
        return CartRepository.findAll();
    }

    public void removeBookByISBN(long bookISBN){
        try{
            CartRepository.removeByBookISBN(bookISBN);
        }   catch (Exception e) {
        e.printStackTrace();
        throw e;
        }
    }

    public void removeBookByName(String name){
        try{
            CartRepository.deleteByName(name);
        }   catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
