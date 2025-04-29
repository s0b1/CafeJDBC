package brainacad.jdbc;

import brainacad.entity.Order;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO
{
    public void addOrder(int clientId, int staffId, String itemType, int itemId, LocalDate date) throws SQLException
    {
        String sql = "INSERT INTO orders (client_id, staff_id, item_type, item_id, order_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, clientId);
            ps.setInt(2, staffId);
            ps.setString(3, itemType);
            ps.setInt(4, itemId);
            ps.setDate(5, Date.valueOf(date));
            ps.executeUpdate();
        }
    }

    public void deleteOrderById(int id) throws SQLException
    {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Order> getOrdersByClient(int clientId) throws SQLException
    {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE client_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("id"),
                        clientId,
                        rs.getInt("staff_id"),
                        rs.getString("item_type"),
                        rs.getInt("item_id"),
                        rs.getDate("order_date").toLocalDate()
                ));
            }
        }
        return orders;
    }
}