package timely.userManagement;

public class Worker extends Employee
{
//    HashMap<K, V> schedule; 
//    HashMap<K, V> availibilty;

    public Worker(String name, int age, String address, String position, String empID, int PIN)
    {

	super(name, age, address, position, empID, PIN);

    }

    public boolean ClockIn()
    {

	return false;

    }

    public boolean clockOut()
    {

	return false;

    }

    public boolean breakIn()
    {

	return false;

    }

    public boolean breakOut()
    {

	return false;

    }


}
