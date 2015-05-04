package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.allOf;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private ArrayList<Book> availableBooks;
    private Book book1;
    private UserInputStream userInputStream;
    private ArrayList<Book> unavailableBooks;
    private List<Movie> availableMovies;
    private Movie movie;

    @Before
    public void setUp() {
        userInputStream = mock(UserInputStream.class);
        printStream = mock(PrintStream.class);
        book1 = new Book("Title", "Author", "Year");
        availableBooks = new ArrayList<Book>();
        availableBooks.add(book1);
        unavailableBooks = new ArrayList<Book>();
        unavailableBooks.add(book1);
        movie = new Movie("Name", "Year", "Director", 10);
        availableMovies = new ArrayList<Movie>();
        availableMovies.add(movie);
        biblioteca = new Biblioteca(printStream, availableBooks, unavailableBooks, userInputStream, availableMovies);
    }

    @Test
    public void shouldPrintEachBook() {
        biblioteca.listBooks();

        verify(printStream, times(availableBooks.size())).println(anyString());
    }

    @Test
    public void shouldPrintBookObjectsFromListBooks(){
        biblioteca.listBooks();

        verify(printStream).println(contains(book1.toString()));
    }

    @Test
    public void shouldGetUserInputOnCheckout() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkoutBook();

        verify(userInputStream).getUserInput();
    }

    @Test
    public void shouldAskUserWhatBookTheyWantToCheckout() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkoutBook();

        verify(printStream).println("Input the book you would like to checkout:");
    }

    @Test
    public void shouldCheckoutSelectedBook() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkoutBook();
        biblioteca.listBooks();

        verify(printStream, never()).println(contains("Title"));
    }

    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulCheckout() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkoutBook();

        verify(printStream).println(contains("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageOnUnsuccessfulCheckout() {
        when(userInputStream.getUserInput()).thenReturn("3");

        biblioteca.checkoutBook();

        verify(printStream).println(contains("That book is not available."));
    }

    @Test
    public void shouldHaveBookAfterCheckIn() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkInBook();

        assertTrue(unavailableBooks.isEmpty());
    }

    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulCheckIn() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkInBook();

        verify(printStream).println(contains("Thank you for returning the book."));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageOnUnsuccessfulCheckIn() {
        when(userInputStream.getUserInput()).thenReturn("Invalid Book Number");

        biblioteca.checkInBook();

        verify(printStream).println(contains("That is not a valid book to return."));
    }

    @Test
    public void shouldListCheckedOutBookWhenUserWantsToCheckIn() {
        when(userInputStream.getUserInput()).thenReturn("Check In Book");

        biblioteca.checkInBook();

        verify(printStream).println(contains("Title"));
    }

    @Test
    public void shouldListAllAvailableMovies() {
        when(userInputStream.getUserInput()).thenReturn("List Movies");

        biblioteca.listMovies();

        verify(printStream).println(contains("Name"));
    }
}
