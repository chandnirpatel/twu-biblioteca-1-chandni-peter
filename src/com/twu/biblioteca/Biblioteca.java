package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;


public class Biblioteca {
    private PrintStream printStream;
    private List<Book> availableBooks;
    private List<Book> unavailableBooks;
    private UserInputStream userInputStream;
    private List<Movie> availableMovies;

    public Biblioteca(PrintStream printStream, List<Book> books, List<Book> unavailableBooks, UserInputStream userInputStream, List<Movie> availableMovies) {
        this.printStream = printStream;
        this.availableBooks = books;
        this.unavailableBooks = unavailableBooks;
        this.userInputStream = userInputStream;
        this.availableMovies = availableMovies;
    }

    public void listBooks(List<Book> list) {
        int counter = 1;
        for (Book book : list) {
            this.printStream.println(counter + ". " + book);
            counter++;
        }
    }

    public void checkoutBook() {
        String bookNumber = getBookNumberFromUser("Input the book you would like to checkout:");

        if (isValidBookNumberForList(bookNumber, availableBooks)) {
            moveBookBetweenLists(Integer.parseInt(bookNumber), availableBooks, unavailableBooks);
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }
    }

    public void checkInBook() {
        listBooks(unavailableBooks);

        String bookNumber = getBookNumberFromUser("Input the book you would like to return:");

        if (isValidBookNumberForList(bookNumber, unavailableBooks)) {
            moveBookBetweenLists(Integer.parseInt(bookNumber), unavailableBooks, availableBooks);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    private boolean isValidBookNumberForList(String bookNumber, List<Book> list) {
        return bookNumber.matches("^[1-9]+") && list.size() >= Integer.parseInt(bookNumber);
    }

    private String getBookNumberFromUser(String prompt) {
        printStream.println(prompt);
        return userInputStream.getUserInput();
    }

    private void moveBookBetweenLists(int bookNumber, List<Book> source, List<Book> destination) {
        Book bookToMove = source.remove(bookNumber - 1);
        destination.add(bookToMove);
    }

    public void listMovies() {
        printStream.println(availableMovies.get(0).details());
    }
}

