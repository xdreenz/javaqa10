package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoviesManagerTest {

    MovieItem item1 = new MovieItem(1, "Фильм 1", "жанр 1");
    MovieItem item2 = new MovieItem(2, "Фильм 2", "жанр 2");
    MovieItem item3 = new MovieItem(3, "Фильм 3", "жанр 3");
    MovieItem item4 = new MovieItem(4, "Фильм 4", "жанр 4");
    MovieItem item5 = new MovieItem(5, "Фильм 5", "жанр 5");


    @Test
    void shouldFindAll() {
        MoviesManager moviesManager = new MoviesManager();
        moviesManager.addMovie(item1);
        moviesManager.addMovie(item2);
        moviesManager.addMovie(item3);
        moviesManager.addMovie(item4);

        MovieItem[] expected = new MovieItem[] { item1, item2, item3, item4 };
        MovieItem[] actual = moviesManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindLastIfLimitIsLessThanArray() {
        MoviesManager moviesManager = new MoviesManager(3);
        moviesManager.addMovie(item1);
        moviesManager.addMovie(item2);
        moviesManager.addMovie(item3);
        moviesManager.addMovie(item4);
        moviesManager.addMovie(item5);

        MovieItem[] expected = new MovieItem[] { item5, item4, item3 };
        MovieItem[] actual = moviesManager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindLastIfLimitIsMoreThanArray() {
        MoviesManager moviesManager = new MoviesManager(7);
        moviesManager.addMovie(item1);
        moviesManager.addMovie(item2);
        moviesManager.addMovie(item3);
        moviesManager.addMovie(item4);
        moviesManager.addMovie(item5);

        MovieItem[] expected = new MovieItem[] { item5, item4, item3, item2, item1 };
        MovieItem[] actual = moviesManager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }
}