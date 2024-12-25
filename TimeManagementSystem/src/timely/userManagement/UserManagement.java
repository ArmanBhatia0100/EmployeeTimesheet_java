package timely.userManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement
{
    static Scanner scanner = new Scanner(System.in);
    private static int empID = 0;
    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static boolean authenticateAdmin()
    {

	boolean authenticated = false;

	// Try-with-resources ensures the scanner is closed automatically

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

	String firstName;
	String lastName;
	String fullName;
	String position = "";
	String address;
	String empID;
	int age;
	int PIN;

	System.out.print("Enter firstname: ");
	firstName = scanner.next();

	System.out.print("Enter lastname: ");
	lastName = scanner.next();

	fullName = firstName + lastName;

	System.out.print("Enter Age: ");
	age = scanner.nextInt();
	scanner.nextLine();

	System.out.print("Enter Address: ");
	address = scanner.nextLine();

	System.out
		.println("What is the position: \n 1. Worker \\n\" + \"2. Supervisor \\n\" + \"3. Manager \n Choice: ");

	switch (scanner.nextInt()) {

	case 1 -> position = "Worker";
	case 2 -> position = "Supervisor";
	case 3 -> position = "Manager";
	default -> throw new IllegalArgumentException("Unexpected value: " + scanner);

	}

	scanner.nextLine();

	empID = UserManagement.generateEmpId(position);

	System.out.print("Enter your PIN: ");
	PIN = scanner.nextInt();

	return position;

    }

    public static void workerMenuSelection(Employee employee)
    {

	Worker worker = (Worker) employee;

	boolean isExit = false;

	while (!isExit)
	{

	    System.out.println("1. Clock In");
	    System.out.println("2. Clock Out");
	    System.out.println("3. Break In");
	    System.out.println("4. Break Out");
	    System.out.println("5. Show timesheet");
	    System.out.println("6. Exit");
	    System.out.print("Choice: ");
	    int userSelection = scanner.nextInt();
	    System.out.println("----------------");

	    switch (userSelection) {

	    case 1: {

		worker.ClockIn();
		break;

	    }

	    case 2: {

		worker.clockOut();
		break;

	    }

	    case 3: {

		worker.breakIn();
		break;

	    }

	    case 4: {

		worker.breakOut();
		break;

	    }

	    case 5: {

		worker.getTimesheet();
		break;

	    }

	    case 6: {

		isExit = true;
		break;

	    }

	    default:
		throw new IllegalArgumentException("Unexpected value: " + userSelection);

	    }

	}

    }


}
