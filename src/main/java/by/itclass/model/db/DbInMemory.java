package by.itclass.model.db;

import by.itclass.model.entities.Country;

import java.util.ArrayList;
import java.util.List;

public class DbInMemory {
    private static List<Country> countries = new ArrayList<>();

    static {
        countries.add(new Country(1, "USA", "Washington", "Joe Biden", 340000000));
        countries.add(new Country(1, "Poland", "Warsaw", "Andrjey Duda", 60000000));
        countries.add(new Country(1, "Kazakhstan", "Astana", "Kasyn-Jomart Toqaev", 19000000));
        countries.add(new Country(1, "France", "Paris", "Emmanuel Macrone", 82000000));
    }
}