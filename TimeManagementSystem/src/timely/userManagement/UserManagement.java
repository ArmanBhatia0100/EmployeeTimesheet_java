package timely.userManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement
{
    private static int empID = 0;
    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static boolean authenticateAdmin()
    {

	boolean authenticated = false;

	// Try-with-resources ensures the scanner is closed automatically
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter admin username: ");
	String username = scanner.next();

	System.out.print("Enter admin password: ");
	String password = scanner.next();

	// Authenticate the user

	if (username.equals("root") && password.equals("root"))
	{

	    authenticated = true;

	} else
	{

	    System.out.println("Invalid username or password.");
	    System.exit(0);

	}

	return authenticated;

    }

    public static String generateEmpId(String position)
    {

	empID++;

	if (position.equals("Manager"))
	{

	    return "M" + empID;

	} else
	{

	    return "E" + empID;

	}

    }

    public static ArrayList<Employee> getEmployees()
    {

	return employees;

    }

    public static void setEmployees(Employee E)
    {

	employees.add(E);

    }

    public String getEmployeeInfoFromConsole()
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

	return position;

    }


}
