package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.Wishlist;
import com.example.demo.entities.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.WishlistRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private BookService bookService;
    private List<Wishlist> wishlists = new ArrayList<Wishlist>();


    public List<Wishlist> findAll(){

        return wishlistRepository.findAll();

    }
    public Wishlist findbyWishlistName(String wishlist_name){
        try{
            return wishlistRepository.findbyWishlistName(wishlist_name);
        } catch (NoSuchElementException e) {
            throw e;
        }

    }
    /*
        public List<Wishlist> findAllByUser(User user) {
            try {
                return wishlistRepository.findAllByUser(user);
            } catch (NoSuchElementException e) {
                throw e;
            }
        }
      */
    public List<Wishlist> findAllByUser(User user) {
        try {
            return wishlistRepository.findAllByUser(user);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }
    public Wishlist saveWishlist(Wishlist inputtedWishlist) {
        try {
           // System.out.println("size of all by user: %i" + findAllByUser(inputtedWishlist.getUser()).size());
           if(findAllByUser(inputtedWishlist.getUser()).size()<3) {
               boolean contains = false;
               System.out.println(findAll().size());
               for (int i = 0; i < findAll().size(); i++) {
                   if ((findAll().get(i).getWishlist_name().compareTo(inputtedWishlist.getWishlist_name())) == 0) {
                       contains = true;
                   }
                   System.out.println(i);
                   System.out.println(contains);
               }
               if (contains == false) {
                   Wishlist wishlist = new Wishlist();
                   BeanUtils.copyProperties(inputtedWishlist, wishlist); // instead of using many getters and setters; only works if inputtedBook and book has exact same variable names
                   this.wishlistRepository.save(wishlist);
                   System.out.println("Wishlist saved successfully");
                   return wishlist;
               } else {
                   System.out.println("Wishlist already exists.");
                   return inputtedWishlist;
               }
           } else {
               return inputtedWishlist;
           }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Wishlist updateWishlist(Wishlist wishlist){
        Wishlist oldWishlist = wishlistRepository.findbyWishlistName(wishlist.getWishlist_name());
        wishlistRepository.delete(oldWishlist);
        wishlistRepository.save(wishlist);
        return wishlist;
    }
    public Wishlist addBookToWishlist(Book book, Wishlist wishlist){
        System.out.println("at beginning of service.");
        Set<Book> booksinwish = wishlist.getBooks_in_wishlist();
        //System.out.println(book.getBookName());
        Set<Wishlist>  wishlistsbookisin = book.getWishlists();
        wishlistsbookisin.add(wishlist);
        booksinwish.add(book);
        wishlist.setBooks_in_wishlist(booksinwish);
        book.setWishlists(wishlistsbookisin);
        updateWishlist(wishlist);
        bookService.updateBook(book);
        //bookService.updateBook(book);
        System.out.println("at end of service.");
        return wishlist;
    }
}
