import com.employee.*;
import com.database.*;

public class Main {

	/**
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {		
		DatabaseOperations db = new DatabaseOperations();
		if(!db.connectToDatabase()) {
			System.out.println("Can't connect to database.");
		}
		
		Employee employee = new Employee("Michael", "Hawkins", 21, Employee.Gender.MALE);
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
