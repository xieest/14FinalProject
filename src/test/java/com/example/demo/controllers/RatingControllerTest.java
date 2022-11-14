package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.RatingRepository;
import com.example.demo.services.RatingService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RatingControllerTest {

    @Mock
    private RatingService ratingService;

    @InjectMocks
    private RatingController ratingController;

    Rating rating1 = new Rating();
    Rating rating2 = new Rating();
    Rating rating3 = new Rating();

    Book book1 = new Book();

    User user1 = new User();

    @BeforeEach
    public void setup() throws IOException {

        rating1 = new Rating();
        rating1.setRatingId(1);
        rating1.setRating(4);
        rating1.setDatestamp(LocalDateTime.now().toString());
        rating1.setBook(Mockito.mock(Book.class));
        rating1.setComment("This is the first mock comment for my test");
        rating1.setUser(Mockito.mock(User.class));

        rating2 = new Rating();
        rating2.setRatingId(2);
        rating2.setRating(5);
        rating2.setDatestamp(LocalDateTime.now().toString());
        rating2.setBook(Mockito.mock(Book.class));
        rating2.setComment("This is the second mock comment for my test");
        rating2.setUser(Mockito.mock(User.class));

        rating3 = new Rating();
        rating3.setRatingId(3);
        rating3.setRating(6);
        rating3.setDatestamp(LocalDateTime.now().toString());
        rating3.setBook(Mockito.mock(Book.class));
        rating3.setComment("This is the third mock comment for my test");
        rating3.setUser(Mockito.mock(User.class));

    }


    @Test
    void saveRating() {

        when(ratingService.saveRating(any(Rating.class))).then(AdditionalAnswers.returnsFirstArg());
        ResponseEntity<Rating> first = ratingController.saveRating(rating1);
        assertThat(first.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ResponseEntity<Rating> second = ratingController.saveRating(rating2);
        System.out.println(second.getStatusCode());
        System.out.println(second.getBody());
        assertThat(second.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // Ensuring that if the rating is not between 1 and 5, the rating controller does not create the resource
        ResponseEntity<Rating> third = ratingController.saveRating(rating3);
        System.out.println(third.getStatusCode());
        assertThat(third.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Test
    void getAllRatings() {

        when(ratingService.saveRating(any(Rating.class))).then(AdditionalAnswers.returnsFirstArg());
        Rating saved1 = ratingService.saveRating(rating1);
        Rating saved2 = ratingService.saveRating(rating2);

        List<Rating> ratings = new ArrayList<>();
        ratings.add(saved1);
        ratings.add(saved2);

        given(ratingService.findAll()).willReturn(ratings);
        List<Rating> retrievedRatings = ratingController.getAllRatings().getBody();
        System.out.println(retrievedRatings.get(0).toString());
        assertThat(retrievedRatings).isNotNull();

        assertEquals(HttpStatus.OK, ratingController.getAllRatings().getStatusCode());
    }

    @Test
    void getRatingsSorted() {

        book1 = new Book();
        book1.setBookISBN(1234124112);
        book1.setBookAuthor("Some author");
        book1.setBookDescription("Some description");
        book1.setBookGenre("Some genre");
        book1.setBookName("Some book name");
        book1.setBookPrice(40.20);
        book1.setBookPublisher("Some publisher");
        book1.setBookCataloguePosition(1);
        book1.setBooksSold(1234);
        book1.setBookYear(2022);

        user1.setUserName("email here");
        user1.setFirstName("Tester");
        user1.setLastName("Ace");
        user1.setPassword("Password");
        user1.setHomeAddress("Address");

        rating1.setUser(user1);
        rating1.setBook(book1);

        rating2.setUser(user1);
        rating2.setBook(book1);

        when(ratingService.saveRating(any(Rating.class))).then(AdditionalAnswers.returnsFirstArg());
        Rating saved1 = ratingController.saveRating(rating1).getBody();
        Rating saved2 = ratingController.saveRating(rating2).getBody();

        List<Rating> ratings = new ArrayList<>();
        ratings.add(saved1);
        ratings.add(saved2);

        List<Rating> sortedRatings = new ArrayList<>();
        sortedRatings.add(saved1);
        sortedRatings.add(saved2);

        given(ratingService.findAll()).willReturn(sortedRatings);
        List<Rating> retrievedRatings = ratingController.getRatingsSorted().getBody();
        assertThat(retrievedRatings).isNotNull();

        // Checking to see the list of ratings was properly sorted

        assertEquals(HttpStatus.OK, ratingController.getAllRatings().getStatusCode());
        assertEquals(5, retrievedRatings.get(0).getRating());
        assertEquals(4, retrievedRatings.get(1).getRating());
        assertEquals(4, ratings.get(0).getRating());
        assertEquals(5, ratings.get(1).getRating());
    }


}