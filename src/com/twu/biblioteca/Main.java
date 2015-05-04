package com.twu.biblioteca;

import com.twu.biblioteca.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(System.out, books(), new ArrayList<Book>(), new UserInputStream(), movies());
        Menu menu = new Menu(System.out, biblioteca, new UserInputStream(), initializeMapMenu(biblioteca));

        menu.start();
    }

    private static Map<String, Command> initializeMapMenu(Biblioteca biblioteca) {
        Map<String, Command> mapMenuCommand = new HashMap<String, Command>();
        mapMenuCommand.put("List Books", new ListBooksCommand(biblioteca));
        mapMenuCommand.put("Check Out Book", new CheckOutBookCommand(biblioteca));
        mapMenuCommand.put("Check In Book", new CheckInBookCommand(biblioteca));
        mapMenuCommand.put("List Movies", new ListMoviesCommand(biblioteca));

        return mapMenuCommand;
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Ender's Game", "Someone", "1985"));
        books.add(new Book("The Hobbit", "J.R. Tolkien", "1940"));
        books.add(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"));

        return books;
    }

    private static List<Movie> movies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("The Avengers", "2015", "Joss Whedon", 10));
        return movies;
    }
}
