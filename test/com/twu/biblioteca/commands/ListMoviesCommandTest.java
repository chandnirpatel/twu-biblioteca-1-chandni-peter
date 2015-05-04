package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Movie;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ListMoviesCommandTest {

    @Test
    public void shouldListMoviesOnExecute() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        ListMoviesCommand listMoviesCommand = new ListMoviesCommand(biblioteca);

        listMoviesCommand.execute();

        verify(biblioteca).listMovies();
    }
}