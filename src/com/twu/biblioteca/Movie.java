package com.twu.biblioteca;

public class Movie {
    private String name;
    private String year;
    private String director;
    private int rating;

    public Movie(String name, String year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String details() {
        return String.format("%-50s|%-20s|%-4s|%-2s", name, director, year, rating);
    }
}
