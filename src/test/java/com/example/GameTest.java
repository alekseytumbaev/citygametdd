package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class GameTest {

    Scanner scanner = Mockito.mock(Scanner.class);

    @ParameterizedTest
    @ValueSource(ints = { Constants.MIN_PLAYERS - 1, Constants.MAX_PLAYERS + 1 })
    void testPlayersNumberShouldNotBeLessThan2OrGreaterThan20(int input) {
        Game game = new Game(scanner);

        String inputStr = String.valueOf(input);
        assertTrue(game.convertPlayersNumberIfValid(inputStr) < 0);
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "sdfs", "1.1" })
    void testShouldNotAcceptNonIntegers(String input) {
        Game game = new Game(scanner);
        assertTrue(game.convertPlayersNumberIfValid(input) < 0);
    }

    @ParameterizedTest
    @ValueSource(ints = { Constants.MIN_PLAYERS, Constants.MIN_PLAYERS + 1, Constants.MAX_PLAYERS })
    void testPlayersNumberShouldBeTheSameAsInput(int input) {
        String inputStr = String.valueOf(input);
        when(scanner.nextLine()).thenReturn(inputStr);

        Game game = new Game(scanner);
        game.readPlayersNumber();
        assertEquals(input, game.playersNumber);
    }
}
