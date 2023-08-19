package ru.netology.javaqa;

public class MoviesManager {
    private MovieItem[] movies = {};
    private int limitSize;


    public MoviesManager() {
        limitSize = 5;
    }

    public MoviesManager(int limitSize) {
        this.limitSize = limitSize;
    }

    public void addMovie(MovieItem movieItem) {
        MovieItem[] tmp = new MovieItem[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[movies.length] = movieItem;
        movies = tmp;
    }

    public MovieItem[] findAll() {
        return movies;
    }

    public MovieItem[] findLast() {
        int resultLength = Math.min(limitSize, movies.length);
        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - i - 1];
        }

        return result;
    }
}
