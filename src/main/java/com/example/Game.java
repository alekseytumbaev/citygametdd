package com.example;

import java.util.Scanner;

import com.example.exception.TimeIsUpException;

public class Game {

    private final Scanner scanner;
    private final CityManager cityManager;

    /**
     * Количество игроков
     */
    int playersNumber;

    /**
     * Номера игроков. Если игрок выбыл, его номер становится -1
     */
    int[] players;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        this.cityManager = new CityManager(scanner);
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

    /**
     * Инициализирует массив с номерами игроков.
     */
    void initializePlayersArray() {
        players = new int[playersNumber];
        for (int i = 0; i < players.length; i++) {
            players[i] = i + 1;
        }
    }

    /**
     * Зацикливает ходы игроков, пока не останется только один.
     * Игрок выбывает, если не успел ввести город за
     * {@link Constants.CITY_INPUT_TIME} секунд
     */
    void loopMoves() {
        while (playersNumber > 1) {
            for (int i = 0; i < players.length && playersNumber > 1; i++) {
                int currentPlayer = players[i];
                if (currentPlayer < 1) {
                    continue;
                }
                System.out.println("Игрок " + currentPlayer + ", введите город: ");
                try {
                    cityManager.readCity();
                } catch (TimeIsUpException e) {
                    players[i] = -1;
                    playersNumber--;
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
