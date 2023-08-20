package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {
    private static final String QUERY_NAME = "SELECT id, name, capital, president,population FROM country WHERE name LIKE ?";
    private static final String QUERY_ID = "SELECT id, name, capital, president,population FROM country WHERE id>=? AND id<=?";

    public Country findByName(String name) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = cn.prepareStatement(QUERY_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String capital = resultSet.getString("capital");
                String president = resultSet.getString("president");
                int population = resultSet.getInt("population");
                return new Country(id, name, capital, president, population);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Country> findCountryByIds(int from, int to) {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(QUERY_ID)) {
            ps.setInt(1, from);
            ps.setInt(2, to);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String capital = rs.getString("capital");
                String president = rs.getString("president");
                int population = rs.getInt("population");
                countries.add(new Country(id, name, capital, president, population));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
