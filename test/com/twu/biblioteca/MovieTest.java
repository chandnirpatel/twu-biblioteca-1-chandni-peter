package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;


public class MovieTest {

    @Test
    public void shouldProvideMovieDetailsWhenRequested() {
        String name = "name";
        String director = "director";
        String year = "year";
        int rating = 1;

        Movie movie = new Movie(name,year,director,rating);

        String movieDetails = movie.details();

        assertEquals(String.format("%-50s|%-20s|%-4s|%-2s", name, director, year, rating), movieDetails);
    }
}