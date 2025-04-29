package brainacad.jdbc;

import brainacad.entity.Schedule;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO
{
    public void addSchedule(int staffId, LocalDate date, LocalTime start, LocalTime end) throws SQLException
    {
        String sql = "INSERT INTO schedule (staff_id, work_date, start_time, end_time) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, staffId);
            ps.setDate(2, Date.valueOf(date));
            ps.setTime(3, Time.valueOf(start));
            ps.setTime(4, Time.valueOf(end));
            ps.executeUpdate();
        }
    }

    public List<Schedule> getScheduleByDate(LocalDate date) throws SQLException
    {
        List<Schedule> list = new ArrayList<>();
        String sql = "SELECT * FROM schedule WHERE work_date = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setDate(1, Date.valueOf(date));
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Schedule schedule = new Schedule(rs.getInt("id"), rs.getInt("staff_id"),
                        rs.getDate("work_date").toLocalDate(), rs.getTime("start_time").toLocalTime(),
                        rs.getTime("end_time").toLocalTime());
                list.add(schedule);
            }
        }
        return list;
    }

    public void updateScheduleForDate(int staffId, LocalDate date, LocalTime newStart, LocalTime newEnd) throws SQLException
    {
        String sql = "UPDATE schedule SET start_time = ?, end_time = ? WHERE staff_id = ? AND work_date = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setTime(1, Time.valueOf(newStart));
            ps.setTime(2, Time.valueOf(newEnd));
            ps.setInt(3, staffId);
            ps.setDate(4, Date.valueOf(date));
            ps.executeUpdate();
        }
    }

    public void deleteScheduleByDate(LocalDate date) throws SQLException
    {
        String sql = "DELETE FROM schedule WHERE work_date = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setDate(1, Date.valueOf(date));
            ps.executeUpdate();
        }
    }
}