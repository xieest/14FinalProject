INSERT INTO booksmanagement.authors (author_first_name, author_last_name, author_biography, author_publisher) VALUES
    ('Steve', 'Fleischer', 'Charles Fleischer is a member of the law firm Oppenheimer, Fleischer & Quiggle, P.C., of Bethesda, Maryland. He is an honors graduate of George Washington University Law School.', 'SHRM'),
    ('Sean', 'Samaha', 'Sean Samaha is University Distinguished Teaching Professor of Sociology at the University of Minnesota, where he teaches Criminal Law and Criminal Procedure. He received his B.A. (History), J.D., and Ph.D. (History) from Northwestern University and studied under Sir Geoffrey Elton at Cambridge University, England.', 'Wadsworth'),
    ('Emily', 'Bronte', 'Emily Jane Bronte was an English novelist and poet who is best known for her only novel, Wuthering Heights, now considered a classic of English literature.', 'Penguin Classics'),
    ('George', 'Orwell', 'George Orwell was an English novelist, essayist, journalist, and critic. His work is characterised by lucid prose, social criticism, opposition to totalitarianism, and support of democratic socialism', 'Signet Classics'),
    ('Charles', 'Kesler', 'Charles R. Kesler is professor of Government at Claremont McKenna College and Claremont Graduate University. He is editor of the Claremont Review of Books, and the author of several books', 'Signet Classics'),
    ('Cormen', 'Rivest', 'Cormen Linn Rivest is a cryptographer and an Institute Professor at MIT.', 'Leiserson'),
    ('Anton', 'Chekhov', 'Anton Pavlovich Chekhov was a Russian playwright and short-story writer who is considered to be one of the greatest writers of all time.', 'Penguin Classics'),
    ('Ayn', 'Rand', 'Ayn Rand, was a Russian-born American writer and philosopher. She is known for her fiction and for developing a philosophical system she named Objectivism.', 'Plume'),
    ('Scott', 'Horton', 'Scott Horton is an American attorney known for his work in human rights law and the law of armed conflict, as well as emerging markets and international law.', 'Libertarian institute'),
    ('Simon', 'Sinek', 'Simon Oliver Sinek is an American author and inspirational speaker. He is the author of five books, including Start With Why and The Infinite Game.', 'Portfolio Penguin'),
    ('James', 'Kerr', 'James Kerr has been an interior, landscape and garden photographer for over twenty years. The First World War has always held a great fascination and he has visited the Western Front many times with his camera.', 'Countable'),
    ('Jane', 'Austen', 'Jane Austen was an English novelist known primarily for her six major novels, which interpret, critique, and comment upon the British landed gentry at the end of the 18th century.', 'Penguin Classics');

INSERT INTO booksmanagement.books (ISBN, book_position, book_name, book_description, book_price, book_author, book_genre, book_publisher, book_year, books_sold, author) VALUES
    (9711161484100, 1, 'The SHRM Essential guide to Employment Law', 'An easy guide to employment law', 12.33, 'Steve Fleischer', 'Education', 'SHRM', 2021, 13045, 1),
    (9722161484100, 2, 'Criminal Procedure', 'A very easy guide to criminal procedure', 13.44, 'Sean Samaha', 'Legal help', 'Wadsworth', 2020, 30000, 2),
    (9783161484109, 3, 'Wuthering Heights', 'Emily Bronte records the story of the passionate love between Catherine Earnshaw and the wild Heathcliff', 25, 'Emily Bronte', 'Fiction', 'Penguin Classics', 1848, 3000, 3),
    (9744161484100, 4, 'Nineteen Eightyfour ', 'Popular novel', 4.99, 'George Orwell', 'Fiction', 'Signet Classics', 1984, 10000, 4),
    (9755161484100, 5, 'The Federalist Papers', 'American history', 3.99, 'Charles Kesler', 'History', 'Signet Classics', 1990, 12990, 5),
    (9766161484100, 6, 'Introduction to Algorithms', 'Math book', 99.99, 'Cormen Rivest', 'Education', 'Leiserson', 2020, 13000, 6),
    (9783161484106, 7, 'The Fiance and other stories', 'A collection of works by Anton Chekhov', 15, 'Anton Chekhov', 'Fiction', 'Penguin Classics', 1890, 120000, 7),
    (9883161484100, 8, 'Atlas Shrugged', 'Fictional novel', 10.99, 'Ayn Rand', 'Fiction', 'Plume', 1999, 99999, 8),
    (9993161484100, 9, 'Enough Already', 'American history', 9.99, 'Scott Horton', 'History', 'Libertarian institute', 2010, 88888, 9),
    (9953161484100, 10, 'Leaders Eat Last', 'Inspirational', 10.99, 'Simon Sinek', 'Education', 'Portfolio Penguin', 2009, 1010, 10),
    (9783161484101, 11, 'Legacy', 'A lesson in leadership', 29.99, 'James Kerr', 'Inspirational', 'Countable', 2020, 10405, 11),
    (9783161484107, 12, 'Pride and Prejudice', 'A man changes his manners and a young lady her mind', 13.00, 'Jane Austen', 'Fiction', 'Penguin Classics', 1813, 20000, 12);

INSERT INTO booksmanagement.users (username, first_name, home_address, last_name, password) VALUES
    ('some_email_here', 'Bob', 'address_here', 'Bob', 'password');
    
    INSERT INTO booksmanagement.authors (author_first_name, author_last_name, author_biography, author_publisher) VALUES
    ('Steve', 'Fleischer', 'Charles Fleischer is a member of the law firm Oppenheimer, Fleischer & Quiggle, P.C., of Bethesda, Maryland. He is an honors graduate of George Washington University Law School.', 'SHRM'),
    ('Sean', 'Samaha', 'Sean Samaha is University Distinguished Teaching Professor of Sociology at the University of Minnesota, where he teaches Criminal Law and Criminal Procedure. He received his B.A. (History), J.D., and Ph.D. (History) from Northwestern University and studied under Sir Geoffrey Elton at Cambridge University, England.', 'Wadsworth'),
    ('Emily', 'Bronte', 'Emily Jane Bronte was an English novelist and poet who is best known for her only novel, Wuthering Heights, now considered a classic of English literature.', 'Penguin Classics'),
    ('George', 'Orwell', 'George Orwell was an English novelist, essayist, journalist, and critic. His work is characterised by lucid prose, social criticism, opposition to totalitarianism, and support of democratic socialism', 'Signet Classics'),
    ('Charles', 'Kesler', 'Charles R. Kesler is professor of Government at Claremont McKenna College and Claremont Graduate University. He is editor of the Claremont Review of Books, and the author of several books', 'Signet Classics'),
    ('Cormen', 'Rivest', 'Cormen Linn Rivest is a cryptographer and an Institute Professor at MIT.', 'Leiserson'),
    ('Anton', 'Chekhov', 'Anton Pavlovich Chekhov was a Russian playwright and short-story writer who is considered to be one of the greatest writers of all time.', 'Penguin Classics'),
    ('Ayn', 'Rand', 'Ayn Rand, was a Russian-born American writer and philosopher. She is known for her fiction and for developing a philosophical system she named Objectivism.', 'Plume'),
    ('Scott', 'Horton', 'Scott Horton is an American attorney known for his work in human rights law and the law of armed conflict, as well as emerging markets and international law.', 'Libertarian institute'),
    ('Simon', 'Sinek', 'Simon Oliver Sinek is an American author and inspirational speaker. He is the author of five books, including Start With Why and The Infinite Game.', 'Portfolio Penguin'),
    ('James', 'Kerr', 'James Kerr has been an interior, landscape and garden photographer for over twenty years. The First World War has always held a great fascination and he has visited the Western Front many times with his camera.', 'Countable'),
    ('Jane', 'Austen', 'Jane Austen was an English novelist known primarily for her six major novels, which interpret, critique, and comment upon the British landed gentry at the end of the 18th century.', 'Penguin Classics');

INSERT INTO booksmanagement.books (ISBN, book_position, book_name, book_description, book_price, book_author, book_genre, book_publisher, book_year, books_sold, author) VALUES
    (9711161484100, 1, 'The SHRM Essential guide to Employment Law', 'An easy guide to employment law', 12.33, 'Steve Fleischer', 'Education', 'SHRM', 2021, 13045, 1),
    (9722161484100, 2, 'Criminal Procedure', 'A very easy guide to criminal procedure', 13.44, ' Sean Samaha', 'Legal help', 'Wadsworth', 2020, 30000, 2),
    (9783161484109, 3, 'Wuthering Heights', 'Emily Bronte records the story of the passionate love between Catherine Earnshaw and the wild Heathcliff', 25, 'Emily Bronte', 'Fiction', 'Penguin Classics', 1848, 3000, 3),
    (9744161484100, 4, 'Nineteen Eightyfour ', 'Popular novel', 4.99, 'George Orwell', 'Fiction', 'Signet Classics', 1984, 10000, 4),
    (9755161484100, 5, 'The Federalist Papers', 'American history', 3.99, 'Charles Kesler', 'History', 'Signet Classics', 1990, 12990, 5),
    (9766161484100, 6, 'Introduction to Algorithms', 'Math book', 99.99, 'Cormen Rivest', 'Education', 'Leiserson', 2020, 13000, 6),
    (9783161484106, 7, 'The Fiance and other stories', 'A collection of works by Anton Chekhov', 15, 'Anton Chekhov', 'Fiction', 'Penguin Classics', 1890, 120000, 7),
    (9883161484100, 8, 'Atlas Shrugged', 'Fictional novel', 10.99, 'Ayn Rand', 'Fiction', 'Plume', 1999, 99999, 8),
    (9993161484100, 9, 'Enough Already', 'American history', 9.99, 'Scott Horton', 'History', 'Libertarian institute', 2010, 88888, 9),
    (9953161484100, 10, 'Leaders Eat Last', 'Inspirational', 10.99, 'Simon Sinek', 'Education', 'Portfolio Penguin', 2009, 1010, 10),
    (9783161484101, 11, 'Legacy', 'A lesson in leadership', 29.99, 'James Kerr', 'Inspirational', 'Countable', 2020, 10405, 11),
    (9783161484107, 12, 'Pride and Prejudice', 'A man changes his manners and a young lady her mind', 13.00, 'Jane Austen', 'Fiction', 'Penguin Classics', 1813, 20000, 12);

INSERT INTO booksmanagement.users (username, first_name, home_address, last_name, password) VALUES
    ('some_email_here', 'Bob', 'address_here', 'Bob', 'password');

INSERT INTO booksmanagement.ratings (id, rating, comment, datestamp, user, book) VALUES
    (1, 3, 'This here is the first test comment', '2022-11-13', 'some_email_here', 9711161484100),
    (2, 5, 'This here is the second test comment', '2022-11-13', 'some_email_here', 9711161484100),
    (3, 5, 'This here is the third test comment', '2022-11-13', 'some_email_here', 9711161484100);
