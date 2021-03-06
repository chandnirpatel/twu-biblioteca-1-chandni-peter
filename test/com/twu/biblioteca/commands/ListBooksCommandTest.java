package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ListBooksCommandTest {

    @Test
    public void shouldListBooksOnExecute() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        ListBooksCommand listBooksCommand = new ListBooksCommand(biblioteca);

        listBooksCommand.execute();

        verify(biblioteca).listBooks();
    }


}