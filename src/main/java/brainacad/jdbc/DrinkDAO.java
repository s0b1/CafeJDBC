package brainacad.jdbc;

import brainacad.entity.Drink;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrinkDAO
{

    public void addDrink(Drink drink) throws SQLException
    {
        String query = "INSERT INTO drink (name_en, name_other, price) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, drink.getNameEn());
            stmt.setString(2, drink.getNameOther());
            stmt.setDouble(3, drink.getPrice());
            stmt.executeUpdate();
        }
    }

    public List<Drink> getAllDrinks() throws SQLException
    {
        List<Drink> drinks = new ArrayList<>();
        String query = "SELECT * FROM drink";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query))
        {
            while (rs.next())
            {
                Drink drink = new Drink();
                drink.setId(rs.getLong("id"));
                drink.setNameEn(rs.getString("name_en"));
                drink.setNameOther(rs.getString("name_other"));
                drink.setPrice(rs.getDouble("price"));
                drinks.add(drink);
            }
        }
        return drinks;
    }

    public void updateDrinkPrice(Long id, double newPrice) throws SQLException
    {
        String query = "UPDATE drink SET price = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setDouble(1, newPrice);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }

    public void deleteDrink(Long id) throws SQLException
    {
        String query = "DELETE FROM drink WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}