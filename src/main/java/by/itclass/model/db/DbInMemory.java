package by.itclass.model.db;

import by.itclass.model.entities.Country;

import java.util.ArrayList;
import java.util.List;

public class DbInMemory {
    private static List<Country> countries = new ArrayList<>();

    static {
        countries.add(new Country(1, "USA", "Washington", "Joe Biden", 340000000));
        countries.add(new Country(2, "Poland", "Warsaw", "Andrjey Duda", 60000000));
        countries.add(new Country(3, "Kazakhstan", "Astana", "Kasym-Jomart Toqaev", 19000000));
        countries.add(new Country(4, "France", "Paris", "Emmanuel Macrone", 82000000));
    }

    public static boolean isCountryByName(String name){
        return countries.stream().anyMatch(it->it.getName().equalsIgnoreCase(name));
    }
    public static Country findCountryByName(String name){
        return countries.stream().filter(it->it.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
