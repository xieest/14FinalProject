package com.example.demo.services;

import com.example.demo.entities.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
//@Sql(scripts = "/create-data.sql")
//@Sql(scripts = "/cleanup-data.sql", executionPhase = AFTER_TEST_METHOD)
public class RatingServiceJUnitTests {

    @Autowired
    private RatingService ratingService;

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


}
