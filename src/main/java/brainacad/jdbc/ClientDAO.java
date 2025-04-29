package brainacad.jdbc;

import brainacad.entity.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO
{

    public void addClient(Client client) throws SQLException
    {
        String sql = "INSERT INTO client (full_name, birth_date, phone, email, discount) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, client.getFullName());
            stmt.setDate(2, Date.valueOf(client.getBirthDate()));
            stmt.setString(3, client.getPhone());
            stmt.setString(4, client.getEmail());
            stmt.setDouble(5, client.getDiscount());
            stmt.executeUpdate();
        }
    }

    public void updateClientDiscount(Long id, double discount) throws SQLException
    {
        String sql = "UPDATE client SET discount = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setDouble(1, discount);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }

    public List<Client> getAllClients() throws SQLException
    {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Client c = new Client();
                c.setId(rs.getLong("id"));
                c.setFullName(rs.getString("full_name"));
                c.setBirthDate(rs.getDate("birth_date").toLocalDate());
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setDiscount(rs.getDouble("discount"));
                clients.add(c);
            }
        }
        return clients;
    }

    public void deleteClient(Long id) throws SQLException
    {
        String sql = "DELETE FROM client WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}