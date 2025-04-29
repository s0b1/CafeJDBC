package brainacad.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private int id;
    private int staffId;
    private LocalDate workDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Schedule(int id, int staffId, LocalDate workDate, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.staffId = staffId;
        this.workDate = workDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Schedule{id=" + id +
                ", staffId=" + staffId +
                ", workDate=" + workDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime + '}';
    }
}