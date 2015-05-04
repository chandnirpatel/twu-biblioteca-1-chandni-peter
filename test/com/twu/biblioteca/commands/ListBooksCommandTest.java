package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 5/1/15.
 */
public class ListBooksCommandTest {

    @Test
    public void shouldListBooksOnExecute() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        List<Book> availableBooks = mock(List.class);
        ListBooksCommand listBooksCommand = new ListBooksCommand(biblioteca, availableBooks);

        listBooksCommand.execute();

        verify(biblioteca).listBooks(availableBooks);
    }


}