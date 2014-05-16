import com.employee.*;
import com.database.*;
import java.util.Scanner;
public class Main {

	/**
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee first name: ");
		String first_name = sc.next();
		System.out.println("Enter employee last name: ");
		String last_name = sc.next();
		System.out.println("Enter employee age: ");
		int age = sc.nextInt();
		System.out.println("Enter employee gender: ");
		String gender = sc.next();
		DatabaseOperations db = new DatabaseOperations();
		if(!db.connectToDatabase()) {
			System.out.println("Can't connect to database.");
		}
		
		Employee employee = new Employee(first_name, last_name, age, Employee.Gender.MALE);
		employee.setEmployee_id(4);
		
		if(!db.AddEmployee(employee)) {
			System.out.println("Failed to add " + employee.getFirst_name() + " " + employee.getLast_name() + " to database.");
		}
		
		db.displayEmployees();
		
		if(!db.RemoveEmployee(employee)) {
			System.out.println("Failed to remove " + employee.getFirst_name() + " " + employee.getLast_name() + " to database.");
		}
		
		db.displayEmployees();
		db.closeConnection();
	}

}
