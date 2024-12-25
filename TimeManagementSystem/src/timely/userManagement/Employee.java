package timely.userManagement;

public class Employee
{
    private String name;
    private String address;
    public String position;
    public String empID;
    private int age;
    private int PIN;

    public Employee(String name, int age, String address, String position, String empID, int PIN)
    {

	this.name = name;
	this.age = age;
	this.address = address;
	this.position = position;
	this.empID = empID;
	this.PIN = PIN;

    }

    /**
     * @return the name
     */
    public String getName()
    {

	return name;

    }

    /**
     * @return the age
     */
    public int getAge()
    {

	return age;

    }

    /**
     * @return the address
     */
    public String getAddress()
    {

	return address;

    }

    /**
     * @return the position
     */
    public String getPosition()
    {

	return position;

    }

    /**
     * @return the empID
     */
    public String getEmpID()
    {

	return empID;

    }

    /**
     * @param age the age to set
     */
    public void setAge(int age)
    {

	this.age = age;

    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {

	this.address = address;

    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position)
    {

	this.position = position;

    }

    /**
     * @param pIN the pIN to set
     */
    public void setPIN(int pIN)
    {

	PIN = pIN;

    }


}
