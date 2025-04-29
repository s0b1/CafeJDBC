package brainacad.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule
{
    private int id;
    private int staffId;
    private LocalDate workDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Schedule(int id, int staffId, LocalDate workDate, LocalTime startTime, LocalTime endTime)
    {
        this.id = id;
        this.staffId = staffId;
        this.workDate = workDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId()
    {
        return id;
    }
    public int getStaffId()
    {
        return staffId;
    }
    public LocalDate getWorkDate()
    {
        return workDate;
    }
    public LocalTime getStartTime()
    {
        return startTime;
    }
    public LocalTime getEndTime()
    {
        return endTime;
    }
}