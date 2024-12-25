package timely.userManagement;

public class Manager extends Employee
{

    public Manager(String name, int age, String address, String position, String empID, int PIN)
    {

	super(name, age, address, position, empID, PIN);

    }

    public void postSchedule()
    {

	System.out.println("Schedule posted");

    }

    public void changeSchedule()
    {

    }

    public void changeTimesheet()
    {

    }


}
