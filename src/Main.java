import com.employee.*;
import com.database.*;

public class Main {

	/**
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		// Create array of employees
		Employee[] employees = new Employee[5];
		
		Employee employee2 = new Employee("Bob", "Smith", 23, Employee.Gender.MALE);
		employees[0] = employee2;
		Employee employee3 = new Employee("Mike", "Marinetti", 22, Employee.Gender.MALE);
		employee3.setWorking(true);
		employees[1] = employee3;
		Employee employee4 = new Employee("Sarah", "Anderson", 19, Employee.Gender.FEMALE);
		employees[2] = employee4;
		Employee employee5 = new Employee("124F", "jfs45", -3, Employee.Gender.FEMALE);
		employees[3] = employee5;
		StudentEmployee student = new StudentEmployee("Michael", "Hawkins", 21, Employee.Gender.MALE, "A87346159");
		employees[4] = student;
		
		for(Employee e : employees) {
			System.out.println(e);
		}
		
		DatabaseOperations db = new DatabaseOperations();
		db.connectToDatabase();
		db.displayEmployees();
	}

}
