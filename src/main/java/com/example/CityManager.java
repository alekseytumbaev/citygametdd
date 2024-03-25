package com.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CityManager {

    private final Scanner scanner;
    final Set<String> usedCities = new HashSet<>();
    String currentCity;

    public CityManager(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Считывает очередной город.
     * Если игрок вводит некорректный город, то повторяет ввод.
     */
    void readCity() {

    }

    /**
     * Проверят, что город:
     * 1. есть в базе городов
     * 2. не был использован
     * 3. начинается с последней буквы предыдущего города, без учета регистра
     * 
     * @param city
     * @return true, если город подходит, иначе false
     */
    boolean isCityValid(String city) {

    }
}
