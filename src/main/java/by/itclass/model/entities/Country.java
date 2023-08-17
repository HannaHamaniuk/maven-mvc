package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Country {
    private int id;
    private String name;
    private String capital;
    private String president;
    private double population;
}
