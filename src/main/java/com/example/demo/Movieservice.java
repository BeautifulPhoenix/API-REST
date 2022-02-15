package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Movieservice {

    static List<Movie> Movie = new ArrayList<Movie>();
    static {

        Movie Movie1 = new Movie("Regreso al Futuro", 1985);
        Movie Movie2 = new Movie("Piratas del Caribe", 2003);
        Movie Movie3 = new Movie("Abajo el pericopio", 1996);

        Movie.add(Movie3);
        Movie.add(Movie2);
        Movie.add(Movie1);

    }

    public static List<Movie> queryMovies() {
        return Movie;
    }
}
