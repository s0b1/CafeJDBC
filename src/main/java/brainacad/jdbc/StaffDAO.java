package brainacad.jdbc;

import brainacad.entity.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO
{

    public void addStaff(Staff staff) throws SQLException
    {
        String sql = "INSERT INTO staff (full_name, phone, email, position) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, staff.getFullName());
            stmt.setString(2, staff.getPhone());
            stmt.setString(3, staff.getEmail());
            stmt.setString(4, staff.getPosition());
            stmt.executeUpdate();
        }
    }

    public void updatePhone(Long id, String newPhone) throws SQLException
    {
        String sql = "UPDATE staff SET phone = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, newPhone);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }

    public void updateEmail(Long id, String newEmail) throws SQLException
    {
        String sql = "UPDATE staff SET email = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, newEmail);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }

    public List<Staff> getStaffByPosition(String position) throws SQLException
    {
        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE position = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, position);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Staff s = new Staff();
                s.setId(rs.getLong("id"));
                s.setFullName(rs.getString("full_name"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setPosition(rs.getString("position"));
                staffList.add(s);
            }
        }
        return staffList;
    }

    public void deleteStaff(Long id) throws SQLException
    {
        String sql = "DELETE FROM staff WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}