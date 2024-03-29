package com.example;

import java.util.Set;

public final class Constants {
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_PLAYERS = 20;
    public static final int CITY_INPUT_TIME_SEC = 10;
    public static final Set<String> CITIES = Set.of(
            "курск",
            "архангельск",
            "челябинск",
            "барнаул",
            "иваново",
            "великий новгород",
            "тамбов",
            "владимир",
            "москва",
            "рязань",
            "саратов",
            "брянск",
            "воронеж",
            "оренбург",
            "ростов-на-дону",
            "нижний тагил",
            "новосибирск",
            "краснодар",
            "екатеринбург",
            "волгоград",
            "мурманск",
            "якутск",
            "хабаровск",
            "кемерово",
            "казань",
            "севастополь",
            "калуга",
            "астрахань",
            "томск",
            "тула",
            "ижевск",
            "тверь",
            "ульяновск",
            "уфа",
            "иркутск",
            "липецк",
            "санкт-петербург",
            "красноярск",
            "пенза",
            "чита",
            "ярославль",
            "пермь",
            "смоленск",
            "омск",
            "нижний новгород",
            "махачкала",
            "тюмень",
            "самара");

    private Constants() {
        throw new UnsupportedOperationException();
    }
}
