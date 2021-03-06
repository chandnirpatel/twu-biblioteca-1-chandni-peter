package com.twu.biblioteca;

import com.twu.biblioteca.commands.Command;

import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private final PrintStream printStream;
    private final Biblioteca biblioteca;
    private  boolean running;
    private UserInputStream userInputStream;
    private Map<String, Command> mapMenuCommand;

    public Menu(PrintStream printStream, Biblioteca biblioteca, UserInputStream userInputStream, Map<String, Command> mapMenuCommand) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.userInputStream = userInputStream;
        this.mapMenuCommand = mapMenuCommand;
        this.running = true;
    }

    private void displayWelcomeMessage() {
        this.printStream.println("Welcome to Biblioteca!");
    }

    public void start() {
        displayWelcomeMessage();

        while (running) {
            displayMenu();
            String userInput = userInputStream.getUserInput();
            executeCommand(userInput);
        }
        printStream.println("Thank you");
    }

    private void displayMenu() {
        printStream.println();
        for (String option : mapMenuCommand.keySet()) {
            printStream.println(option);
        }
        printStream.println("Quit\n");
    }

    private void executeCommand(String userInput) {
        if (mapMenuCommand.containsKey(userInput)){
            mapMenuCommand.get(userInput).execute();
        }
        else if(userInput.equals("Quit")) {
            running = false;
        }
        else{
            printStream.println("Select a valid option!");
        }
    }
}
