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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class RatingControllerTest {

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private RatingService ratingService;

    @InjectMocks
    private RatingController ratingController;

    Rating rating1 = new Rating();
    Rating rating2 = new Rating();
    Rating rating3 = new Rating();

    @BeforeEach
    public void setup() throws IOException {

        rating1 = new Rating();
        rating1.setRating_id(1);
        rating1.setRating(4);
        rating1.setDatestamp(LocalDateTime.now().toString());
        rating1.setBook(Mockito.mock(Book.class));
        rating1.setComment("This is the first mock comment for my test");
        rating1.setUser(Mockito.mock(User.class));

        rating2 = new Rating();
        rating2.setRating_id(2);
        rating2.setRating(5);
        rating2.setDatestamp(LocalDateTime.now().toString());
        rating2.setBook(Mockito.mock(Book.class));
        rating2.setComment("This is the second mock comment for my test");
        rating2.setUser(Mockito.mock(User.class));

        rating3 = new Rating();
        rating3.setRating_id(3);
        rating3.setRating(6);
        rating3.setDatestamp(LocalDateTime.now().toString());
        rating3.setBook(Mockito.mock(Book.class));
        rating3.setComment("This is the third mock comment for my test");
        rating3.setUser(Mockito.mock(User.class));

    }


    @Test
    void saveRating() {

        ResponseEntity<Rating> first = ratingController.saveRating(rating1);
        assertThat(first.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ResponseEntity<Rating> second = ratingController.saveRating(rating2);
        assertThat(second.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // Ensuring that if the rating is not between 1 and 5, the rating controller does not create the resource
        ResponseEntity<Rating> third = ratingController.saveRating(rating3);
        assertThat(third.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Test
    void getAllRatings() {
        Rating saved1 = ratingService.saveRating(rating1);
        Rating saved2 = ratingService.saveRating(rating2);
        List<Rating> ratings = new ArrayList<>();
        ratings.add(saved1);
        ratings.add(saved2);

        given(ratingService.findAll()).willReturn(ratings);
        List<Rating> retrievedRatings = ratingController.getAllRatings().getBody();
        assertThat(retrievedRatings).isNotNull();

        assertEquals(HttpStatus.OK, ratingController.getAllRatings().getStatusCode());
    }

    @Test //Still working on this test
    void getRatingsSorted() {
        Rating saved1 = ratingService.saveRating(rating1);
        Rating saved2 = ratingService.saveRating(rating2);
        List<Rating> ratings = new ArrayList<>();
        ratings.add(saved1);
        ratings.add(saved2);

//        List<Rating> sortedRatings = new ArrayList<>();
//        sortedRatings.add(saved1);
//        sortedRatings.add(saved2);
        Collections.sort(ratings);

        given(ratingService.findAll()).willReturn(ratings);
        given(ratingController.getRatingsSorted()).willReturn(new ResponseEntity<>(ratings, HttpStatus.OK));
        List<Rating> retrievedRatings = ratingController.getRatingsSorted().getBody();
        assertThat(retrievedRatings).isNotNull();

        retrievedRatings.forEach(rating -> System.out.println(rating.getComment()));

        assertEquals(HttpStatus.OK, ratingController.getAllRatings().getStatusCode());
        System.out.println(retrievedRatings.get(0).toString());
        assertEquals(5, retrievedRatings.get(0).getRating());
        assertEquals(4, retrievedRatings.get(1).getRating());
        assertEquals(4, ratings.get(0).getRating());
        assertEquals(5, ratings.get(1).getRating());
    }


}
