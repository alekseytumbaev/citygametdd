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

    }
}
