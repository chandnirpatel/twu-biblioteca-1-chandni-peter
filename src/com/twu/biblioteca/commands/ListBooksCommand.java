package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;

import java.util.List;

/**
 * Created by kprakobk on 4/30/15.
 */
public class ListBooksCommand implements Command {
    private Biblioteca biblioteca;
    private List<Book> availableBooks;

    public ListBooksCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.availableBooks = availableBooks;
    }

    @Override
    public void execute() {
        biblioteca.listBooks();
    }
}
