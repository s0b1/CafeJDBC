package brainacad.jdbc;

import brainacad.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class OrderDAO
{
    public void addDrinkOrder(int clientId, int staffId, int drinkId, LocalDate date) throws SQLException
    {
        String sql = "INSERT INTO orders (client_id, staff_id, item_type, item_id, order_date) VALUES (?, ?, 'drink', ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, clientId);
            ps.setInt(2, staffId);
            ps.setInt(3, drinkId);
            ps.setDate(4, Date.valueOf(date));
            ps.executeUpdate();
        }
    }

    public void addDessertOrder(int clientId, int staffId, int dessertId, LocalDate date) throws SQLException
    {
        String sql = "INSERT INTO orders (client_id, staff_id, item_type, item_id, order_date) VALUES (?, ?, 'dessert', ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, clientId);
            ps.setInt(2, staffId);
            ps.setInt(3, dessertId);
            ps.setDate(4, Date.valueOf(date));
            ps.executeUpdate();
        }
    }

    public List<Order> getOrdersByClient(int clientId) throws SQLException
    {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE client_id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Order order = new Order(rs.getInt("id"), rs.getInt("client_id"), rs.getInt("staff_id"),
                        rs.getString("item_type"), rs.getInt("item_id"), rs.getDate("order_date").toLocalDate());
                list.add(order);
            }
        }
        return list;
    }

    public void deleteOrderById(int orderId) throws SQLException
    {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, orderId);
            ps.executeUpdate();
        }
    }

    public void updateOrder(int orderId, int newStaffId, int newItemId) throws SQLException
    {
        String sql = "UPDATE orders SET staff_id = ?, item_id = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, newStaffId);
            ps.setInt(2, newItemId);
            ps.setInt(3, orderId);
            ps.executeUpdate();
        }
    }
}