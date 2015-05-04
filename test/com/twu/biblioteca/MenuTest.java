package com.twu.biblioteca;

import com.twu.biblioteca.commands.Command;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class MenuTest {


    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Menu menu;
    private UserInputStream userInputStream;
    private Map<String,Command> mapMenu;
    private Command commandMock;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        userInputStream = mock(UserInputStream.class);
        mapMenu = initializeMapMenu();
        menu = new Menu(printStream, biblioteca, userInputStream, mapMenu);
    }

    private Map<String, Command> initializeMapMenu() {
        Map<String, Command> mapMenuCommand = new HashMap<String, Command>();
        commandMock = mock(Command.class);
        mapMenuCommand.put("Command", commandMock);

        return mapMenuCommand;
    }

    @Test
    public void shouldWelcomeUserOnStartTest() {
        when(userInputStream.getUserInput()).thenReturn("Quit");

        menu.start();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldStartMenuByDisplayingAllPossibleOptionsUsingCommandMapKeys() {
        when(userInputStream.getUserInput()).thenReturn("Quit");
        menu.start();

        verify(printStream).println(contains("Command"));
    }

    @Test
    public void shouldExecuteACommandWithValidInput() {
        when(userInputStream.getUserInput()).thenReturn("Command", "Quit");

        menu.start();

        verify(commandMock).execute();
    }

    @Test
    public void shouldNotExecuteACommandWithInValidInput() {
        when(userInputStream.getUserInput()).thenReturn("Foo", "Quit");

        menu.start();

        verify(commandMock, never()).execute();
    }

    @Test
    public void shouldWarnUserWhenProvidedInvalidOption() {
        when(userInputStream.getUserInput()).thenReturn("Invalid Input!!", "Quit");

        menu.start();

        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldHaveQuitAsAnOption() {
        when(userInputStream.getUserInput()).thenReturn("Quit");

        menu.start();

        verify(printStream).println(contains("Quit"));
    }

    @Test
    public void shouldQuitWhenQuitOptionIsSelected() {
        when(userInputStream.getUserInput()).thenReturn("Quit");

        menu.start();

        verify(printStream).println(contains("Thank you"));
    }

    @Test
    public void shouldContinueRunningUntilUserQuits() {
        when(userInputStream.getUserInput()).thenReturn("Command", "Quit");

        menu.start();

        verify(commandMock).execute();
    }
}