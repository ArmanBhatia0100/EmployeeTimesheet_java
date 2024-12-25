import java.util.Scanner;

import timely.userManagement.Admin;
import timely.userManagement.Employee;
import timely.userManagement.Manager;
import timely.userManagement.UserManagement;

public class TimelyDriver
{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {

	printMainMenu();
	String usertype = getUserType();

	// If user is Admin
	if (usertype.equals("admin"))
	{

	    printAdminMenu(usertype);

	}

	// If user is Employee
	if (!usertype.equals("admin"))
	{

	    printEmployeeMenu(usertype);

	}

    }

    public static void printMainMenu()
    {

	System.out.println();
	System.out.println("Welcome to Timely");
	System.out.println("---------------------");
	System.out.println("1. Admin");
	System.out.println("2. Employee");
	System.out.print("Enter you choice:");

    }

    private static void printAdminMenu(String usertype)
    {

	System.out.println(
		"Good Morning! " + Character.toString(usertype.charAt(0)).toUpperCase() + usertype.substring(1));

	if (UserManagement.authenticateAdmin())
	{

	    Admin admin = new Admin();
	    boolean isExit = false;

	    while (!isExit)
	    {

		System.out.println("-------------------------");
		System.out.println("1. Add Employee");
		System.out.println("2. Remove Employee");
		System.out.println("3. List Employees");
		System.out.println("4. Exit Admin Menu");
		System.out.println("5. Exit");
		System.out.println();
		System.out.print("Enter your choice: ");
		int adminSelection = scanner.nextInt();

		switch (adminSelection) {

		case 1 -> // Add an Employee
		    {

			admin.addEmployee();
			break;

		    }
		case 2 ->
		    {

			admin.removeEmployee();

		    }
		case 3 ->
		    {

			// listAllEmployee();
			admin.getAllEmployee();
			break;

		    }
		case 4 ->
		    {

			// Exit admin menu
			isExit = true;

		    }
		case 5 ->
		    {

			// exit whole program
			System.exit(0);
			;

		    }

		default -> throw new IllegalArgumentException("Unexpected value: ");

		}

	    }

	    TimelyDriver.main(null);

	}

    }

    private static void printEmployeeMenu(String usertype)
    {

	if (UserManagement.employees.size() > 0)
	{

	    System.out.println(
		    "Good Morning! " + Character.toString(usertype.charAt(0)).toUpperCase() + usertype.substring(1));

	    System.out.print("What is your employeeID: ");
	    String employeeID = scanner.next();

	    Employee employee = null;

	    for (Employee emp : UserManagement.employees)
	    {

		if (emp.empID.equals(employeeID))
		{

		    employee = emp;

		}

	    }

	    if (employee != null && employee.empID.startsWith("M"))
	    {

		printManagerMenu(employee);

	    } else if (employee != null && employee.empID.startsWith("E"))
	    {

	    } else
	    {

		System.out.println("------------------------------------------------");
		System.out.println("ERROR: Didn't find an employee, Contact Admin");
		System.out.println("------------------------------------------------");

	    }

	} else
	{

	    System.out.println("Sorry no employee in the system. Try again");
	    main(null);

	}

    }

    private static void printManagerMenu(Employee employee)
    {

	if (employee != null && employee.empID.startsWith("M"))
	{

	    boolean isExit = false;

	    while (!isExit)
	    {

		System.out.println("1. Post Schedule");
		System.out.println("2. Change Schedule");
		System.out.println("3. Change Timesheet");
		System.out.println("4. Exit to main Menu");
		System.out.println("5. Exit the app");
		System.out.print("Enter you choice: ");
		int userSelection = scanner.nextInt();

		switch (userSelection) {

		case 1: {

		    ((Manager) employee).postSchedule();
		    break;

		}

		case 2: {

		    ((Manager) employee).changeSchedule();
		    break;

		}

		case 3: {

		    ((Manager) employee).changeTimesheet();
		    break;

		}

		case 4: {

		    isExit = true;
		    break;

		}

		case 5: {

		    System.exit(0);

		}

		default:
		    throw new IllegalArgumentException("Unexpected value: " + userSelection);

		}

	    }

	    TimelyDriver.main(null);

	}

    }

    private static String getUserType()
    {

	String userType = "";

	while (userType.equals(""))
	{

	    try
	    {

		int userInput = scanner.nextInt();

		switch (userInput) {

		case 1 -> userType = "admin";
		case 2 -> userType = "employee";
		default -> throw new IllegalArgumentException("Unexpected value: " + userInput);

		}

	    } catch (IllegalArgumentException e)
	    {

		System.out.println("Sorry Wrong Arguments, Try Again");
		System.out.println("What is your role: ");
		userType = "";

	    }

	}

	System.out.println("---------------------");

	return userType;

    }


}
