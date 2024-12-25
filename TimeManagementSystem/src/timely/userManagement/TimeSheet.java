package timely.userManagement;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSheet
{
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * @return the date
     */
    public LocalDate getDate()
    {

	return date;

    }

    /**
     * @return the startTime
     */
    public LocalTime getStartTime()
    {

	return startTime;

    }

    /**
     * @return the endTime
     */
    public LocalTime getEndTime()
    {

	return endTime;

    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date)
    {

	this.date = date;

    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(LocalTime startTime)
    {

	this.startTime = startTime;

    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(LocalTime endTime)
    {

	this.endTime = endTime;

    }


}
