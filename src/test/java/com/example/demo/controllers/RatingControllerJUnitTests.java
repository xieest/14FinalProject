package com.example.demo.controllers;
import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import com.example.demo.repositories.RatingRepository;
import com.example.demo.services.BookService;
import com.example.demo.services.RatingService;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
@Sql(scripts = "/create-data.sql")
@Sql(scripts = "/cleanup-data.sql", executionPhase = AFTER_TEST_METHOD)
public class RatingControllerJUnitTests {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private RatingController ratingController;

    Rating rating1 = new Rating();
    Rating rating2 = new Rating();
    Rating rating3 = new Rating();

    @BeforeEach
    public void setup() throws IOException {

        // A roundabout way to create new ratings that I want to use to test my methods

        rating1 = ratingService.findByRatingId(1);
        rating1.setRatingId(4);
        rating1.setRating(4);
        rating1.setDatestamp(LocalDateTime.now().toString());
        rating1.setComment("This is the comment for the fourth rating in my test");

        rating2 = ratingService.findByRatingId(1);
        rating2.setRatingId(5);
        rating2.setRating(5);
        rating2.setDatestamp(LocalDateTime.now().toString());
        rating2.setComment("This is the comment for the fifth rating in my test");

        // This rating will later be used to test the fact that a rating should not be added if it is not between 1 and 5
        rating3 = ratingService.findByRatingId(1);
        rating3.setRatingId(6);
        rating3.setRating(6);
        rating3.setDatestamp(LocalDateTime.now().toString());
        rating3.setComment("This is the comment for the sixth rating in my test");
    }

    @Test
    void testSaveRating() {

        ResponseEntity<Rating> first = ratingController.saveRating(rating1);
        System.out.println(first.getStatusCode());
        System.out.println(first.getBody().getComment());
        assertThat(first.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ResponseEntity<Rating> second = ratingController.saveRating(rating2);
        System.out.println(second.getStatusCode());
        System.out.println(second.getBody().getComment());
        assertThat(second.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // Ensuring that if the rating is not between 1 and 5, the rating controller does not create the resource
        ResponseEntity<Rating> third = ratingController.saveRating(rating3);
        System.out.println(third.getStatusCode());
        assertThat(third.getBody()).isNull();
        assertThat(third.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Test
    void testGetAllRatings() {

        ratingController.saveRating(rating1);
        ratingController.saveRating(rating2);
        ratingController.saveRating(rating3); // As we see later, this rating is invalid and is not saved nor is it retrieved

        List<Rating> ratings = ratingController.getAllRatings().getBody();

        //Shows each rating comment on the terminal so we can confirm all five ratings were retrieved
        ratings.forEach(rating -> System.out.println(rating.getComment()));

        // Should see five ratings, so the list should have length of five
        System.out.println(ratings.size());
        assertThat(ratings.size()).isEqualTo(5);

        //As long as method was successful, httpstatus should be OK
        assertEquals(HttpStatus.OK, ratingController.getAllRatings().getStatusCode());
    }

    @Test
    void testGetRatingsSorted() {

        ratingController.saveRating(rating1);
        ratingController.saveRating(rating2);
        ratingController.saveRating(rating3); // As we see later, this rating is invalid and is not saved nor is it retrieved

        List<Rating> ratings = ratingController.getRatingsSorted().getBody();

        //Shows each rating value on the terminal so we can confirm all five ratings were retrieved in descending order
        ratings.forEach(rating -> System.out.println(rating.getRating()));

        //Shows each comment for each rating; notice the ratings have switched places so they are ordered by rating numbers
        ratings.forEach(rating -> System.out.println(rating.getComment()));

        // Should see five ratings, so the list should have length of five
        System.out.println(ratings.size());
        assertThat(ratings.size()).isEqualTo(5);

    }

    @Test
    void testFindAverageRatingByBook() {

        ratingController.saveRating(rating1);
        ratingController.saveRating(rating2);
        ratingController.saveRating(rating3); // As we see later, this rating is invalid and is not saved nor is it retrieved

        // Because we provide the dummy data, we know the average rating for this book should be 4.4

        double avgRating = ratingController.findAverageRatingByBook(9711161484100L);

        System.out.println(avgRating);

        assertEquals(avgRating, 4.4);

    }
}
