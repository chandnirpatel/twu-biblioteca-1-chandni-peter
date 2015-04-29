package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Menu {

    private final PrintStream printStream;
    private final Biblioteca biblioteca;
    private UserInputStream userInputStream;

    public Menu(PrintStream printStream, Biblioteca biblioteca, UserInputStream userInputStream) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.userInputStream = userInputStream;
    }

    public void displayWelcomeMessage() {
        this.printStream.println("Welcome to Biblioteca!");
    }

    public void startMenu() {
        displayMenu();
        String userInput = userInputStream.getUserInput();
        checkUserInput(userInput);
    }

    private void displayMenu() {
        printStream.println("1. List Books");
    }

    private void checkUserInput(String userInput) {
        if (userInput.equals("List Books")){
            biblioteca.listBooks();
        } else {
            printStream.println("Select a valid option!");
        }
    }


}