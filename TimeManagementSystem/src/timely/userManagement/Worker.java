package timely.userManagement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Worker extends Employee
{
    private boolean isClockedIn = false;
    ArrayList<TimeSheet> timesheetArrayList = new ArrayList<TimeSheet>();
    TimeSheet t1;
//    HashMap<K, V> schedule; 
//    HashMap<K, V> availibilty;

    public Worker(String name, int age, String address, String position, String empID, int PIN)
    {

	super(name, age, address, position, empID, PIN);

    }

    public void ClockIn()
    {

	if (!isClockedIn)
	{

	    t1 = new TimeSheet();

	    t1.setStartTime(LocalTime.now());
	    t1.setDate(LocalDate.now());
	    isClockedIn = true;
	    timesheetArrayList.add(t1);
	    System.out.println("Clocked in");

	} else
	{

	    System.out.println("Already Clocked in");

	}

    }

    public void clockOut()
    {

	t1.setEndTime(LocalTime.now());
	t1.setDate(LocalDate.now());
	isClockedIn = false;

	System.out.println("clocked out ");

    }

    public boolean breakIn()
    {

	System.out.println("break in ");
	return false;

    }

    public boolean breakOut()
    {

	System.out.println("break out");
	return false;

    }

    public void getTimesheet()
    {

//	System.out.println("" + timesheetArrayList.get(0).getDate());
//	System.out.println("" + timesheetArrayList.get(0).getStartTime());
//	System.out.println("" + timesheetArrayList.get(0).getEndTime());

	for (TimeSheet curentTimesheet : timesheetArrayList)
	{

	    Duration duration = Duration.between(curentTimesheet.getStartTime(), curentTimesheet.getEndTime());
	    System.out.println(curentTimesheet.getDate().getDayOfWeek() + ": " + duration.toHours() + "Hours "
		    + duration.toMinutes() + "min " + duration.toSeconds() + "s ");

	}

	System.out.println("--------------------");
	System.out.println("");

    }


}
