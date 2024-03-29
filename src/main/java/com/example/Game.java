package com.example;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;

    /**
     * Количество игроков
     */
    int playersNumber;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Считывает количество игроков.
     * Если введено некорректное число, то повторяет ввод.
     */
    void readPlayersNumber() {
        String str = scanner.nextLine();
        int tmpNumber = convertPlayersNumberIfValid(str);
        while (tmpNumber < 0) {
            System.out.println("Количество игроков должно быть числом от " + Constants.MIN_PLAYERS + " до "
                    + Constants.MAX_PLAYERS);
            str = scanner.nextLine();
            tmpNumber = convertPlayersNumberIfValid(str);
        }
        playersNumber = tmpNumber;
    }

    /**
     * Преобразует кол-во игроков из строки в целое число
     * Если количество игроков не в диапазоне от {@link Constants.MIN_PLAYERS} до
     * {@link Constants.MAX_PLAYERS}
     * или не является числом, то возвращает -1
     * 
     * @param playersNumberStr количество игроков строкой.
     * @return количество игроков числом, либо -1, если ввод неверный
     */
    int convertPlayersNumberIfValid(String playersNumberStr) {
        int playersNumber;
        try {
            playersNumber = Integer.parseInt(playersNumberStr);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (playersNumber >= Constants.MIN_PLAYERS && playersNumber <= Constants.MAX_PLAYERS) {
            return playersNumber;
        }
        return -1;
    }
}
