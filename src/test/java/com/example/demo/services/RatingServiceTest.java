package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.RatingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class RatingServiceTest {

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private RatingService ratingService;

    Rating rating1 = new Rating();
    Rating rating2 = new Rating();
    Rating rating3 = new Rating();

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

    @DisplayName(value = "JUnit test for service method that saves a given rating to the database")
    @Test
    void saveRatingShouldSaveProperlyFormattedRatings() throws Exception{

        Rating firstrating = ratingService.saveRating(rating1);
        assertThat(firstrating).isNotNull();
        assertThat(firstrating.getRating()).isEqualTo(4);

        Rating secondrating = ratingService.saveRating(rating2);
        assertThat(secondrating).isNotNull();
        assertThat(secondrating.getRating()).isEqualTo(5);

    }


    @DisplayName(value = "JUnit test for service method findAll")
    @Test
    void findAllShouldReturnAllSavedRatings() {

        Rating saved1 = ratingService.saveRating(rating1);
        Rating saved2 = ratingService.saveRating(rating2);
        List<Rating> ratings = new ArrayList<>();
        ratings.add(saved1);
        ratings.add(saved2);

        given(ratingRepository.findAll()).willReturn(ratings);
        List<Rating> retrievedRatings = ratingService.findAll();
        assertThat(retrievedRatings).isNotNull();
        System.out.println(retrievedRatings.get(0).toString());
        assertThat(retrievedRatings.get(0).toString()).isEqualTo(ratings.get(0).toString());
    }


}