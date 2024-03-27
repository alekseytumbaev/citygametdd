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
        boolean cityIsValid;
        String city;

        do {
            city = scanner.nextLine();

            cityIsValid = isCityValid(city);
            if (!cityIsValid) {
                System.out.println("Такой город не подойдет. Попробуйте еще раз:");
            }
        } while (!cityIsValid);

        usedCities.add(city);
        currentCity = city;
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
        String lowerCaseCity = city.toLowerCase();
        if (!Constants.CITIES.contains(lowerCaseCity) ||
                usedCities.contains(lowerCaseCity)) {
            return false;
        }

        if (currentCity == null) {
            return true;
        }

        return newCityStartsWithLastLetterOfCurrentCity(lowerCaseCity);
    }

    private boolean newCityStartsWithLastLetterOfCurrentCity(String newCity) {
        if (newCity == null) {
            return false;
        }

        char newChar = Character.toLowerCase(newCity.charAt(0));
        char currChar = Character.toLowerCase(currentCity.charAt(currentCity.length() - 1));
        return newChar == currChar;
    }
}
