package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import com.example.exception.TimeIsUpException;

public class CityManagerTest {

    Scanner scanner = Mockito.mock(Scanner.class);

    @ParameterizedTest
    @ValueSource(strings = { "", "Hogwarts" })
    void testCityShouldBeInCitiesDataBase(String input) {
        CityManager cityManager = new CityManager(scanner);
        assertEquals(false, cityManager.isCityValid(input));
    }

    @Test
    void testCityShouldStartWithLastLetterOfCurrentCity() {
        CityManager cityManager = new CityManager(scanner);
        cityManager.currentCity = "Москва";
        assertEquals(false, cityManager.isCityValid("Барнаул"));
    }

    @Test
    void testShouldAcceptEveryCityIfItIsFirst() {
        String firstCity = "Москва";
        when(scanner.nextLine()).thenReturn(firstCity);
        CityManager cityManager = new CityManager(scanner);
        cityManager.currentCity = null;
        assertEquals(0, cityManager.usedCities.size());

        cityManager.readCity();
        assertEquals(firstCity, cityManager.currentCity);
        assertEquals(1, cityManager.usedCities.size());
    }

    @ParameterizedTest
    @ValueSource(strings = { "Краснодар", "краснодар" })
    void testCitiesValidationShouldBeCaseInsensitive(String input) {
        when(scanner.nextLine()).thenReturn(input);
        CityManager cityManager = new CityManager(scanner);
        cityManager.currentCity = "Брянск";
        assertEquals(0, cityManager.usedCities.size());

        cityManager.readCity();
        assertEquals(cityManager.currentCity.toLowerCase(), input.toLowerCase());
        assertEquals(1, cityManager.usedCities.size());
    }

    @Test
    void testShouldThrowExceptionIfTimeIsUp() {
        when(scanner.nextLine()).then(invocation -> {
            TimeUnit.SECONDS.sleep(Constants.CITY_INPUT_TIME_SEC + 1);
            return "Москва";
        });

        CityManager cityManager = new CityManager(scanner);
        assertThrows(TimeIsUpException.class, () -> cityManager.readCity());
    }
}
