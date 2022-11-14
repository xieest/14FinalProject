DELETE FROM booksmanagement.ratings;

INSERT INTO booksmanagement.ratings (id, rating, comment, datestamp, user, book) VALUES
    (1, 3, 'This here is the first test comment', '2022-11-13', 'some_email_here', 9711161484100),
    (2, 5, 'This here is the second test comment', '2022-11-13', 'some_email_here', 9711161484100),
    (3, 5, 'This here is the third test comment', '2022-11-13', 'some_email_here', 9711161484100);

