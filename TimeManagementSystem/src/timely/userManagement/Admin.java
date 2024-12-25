package timely.userManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin
{
    private String username = "root";
    private String password = "root";

    public void addEmployee()
    {

	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter firstname: ");
	String firstName = scanner.next();

	System.out.print("Enter lastname: ");
	String lastname = scanner.next();
	String name = firstName + lastname;

	System.out.print("Enter Age: ");
	int age = scanner.nextInt();
	scanner.nextLine();

	System.out.print("Enter Address: ");
	String address = scanner.nextLine();

	System.out.println("What is the position:");
	System.out.println("1. Worker \n" + "2. Supervisor \n" + "3. Manager");
	System.out.print("Choice: ");

	String position = "";

	switch (scanner.nextInt()) {

	case 1 -> position = "Worker";
	case 2 -> position = "Supervisor";
	case 3 -> position = "Manager";
	default -> throw new IllegalArgumentException("Unexpected value: " + scanner);

	}

	scanner.nextLine();

	String empID = UserManagement.generateEmpId(position);

	System.out.println("Enter your PIN");
	int PIN = scanner.nextInt();

	if (position.equals("Manager"))
	{

	    Employee manager = new Manager(name, age, address, position, empID, PIN);
	    UserManagement.setEmployees(manager);

	} else
	{

	    Employee worker = new Worker(name, age, address, position, empID, PIN);
	    UserManagement.setEmployees(worker);

	}

	System.out.println("Employee added Successfully");

    }

    private void removeEmployee(int empID)
    {

	UserManagement.removeEmployee(empID);

    }

    public void getAllEmployee()
    {

	ArrayList<Employee> employees = UserManagement.getEmployees();
	System.out.println();

	for (int i = 0; i < employees.size(); i++)
	{

	    System.out.println(i + ": " + employees.get(i).getName() + " ( " + employees.get(i).getEmpID() + " )");

	}

    }


}
