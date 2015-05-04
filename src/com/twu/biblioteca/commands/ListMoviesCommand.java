package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Movie;

import java.util.List;

public class ListMoviesCommand implements Command {
    private Biblioteca biblioteca;


    public ListMoviesCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.listMovies();
    }
}
