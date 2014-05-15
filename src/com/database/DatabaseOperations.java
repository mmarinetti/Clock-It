package com.database;
import com.employee.Employee;
import java.sql.*;

public class DatabaseOperations {
	private static final String DEFAULT_DATABASE_PACKAGE = "org.apache.derby.jdbc.ClientDriver";
	private static final String DEFAULT_DATABASE_URL = "jdbc:derby://localhost:1527/PERSONNEL";
	private static final String MAGIC = "JSOfuwe95u8t";
	
	private String databasePackage;
	private String databaseURL;
	private boolean isConnected = false;
	private Connection conn = null;
	
	public String getDatabasePackage() {
		return databasePackage;
	}

	public void setDatabasePackage(String databasePackage) {
		this.databasePackage = databasePackage;
	}

	public String getDatabaseURL() {
		return databaseURL;
	}

	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}

	public DatabaseOperations() {
		this(DEFAULT_DATABASE_PACKAGE, DEFAULT_DATABASE_URL);
	}
	
	public DatabaseOperations(String pkg, String url) {
		this.setDatabasePackage(pkg);
		this.setDatabaseURL(url);
	}
	
	public boolean connectToDatabase() {
		try {
			Class.forName(databasePackage);
			conn = DriverManager.getConnection(databaseURL, "guest", "password");
		} catch (ClassNotFoundException e) {
			isConnected = false;
			e.printStackTrace();
		} catch (SQLException e) {
			isConnected = false;
			e.printStackTrace();
		}
		
		isConnected = true;
		System.out.println("Connected to database: " + databaseURL);
		
		return isConnected;
	}
	
	public boolean ClockInEmployee(Employee e) {
		return false;
	}
	
	public boolean ClockOutEmployee(Employee e) {
		return false;
	}
	
	public boolean AddEmployee(Employee e) {
		return false;
	}
	
	public boolean RemoveEmployee(Employee e) {
		return false;
	}
	
	public void displayEmployees() {
		String sql = "SELECT * FROM Employees";
		
		try {
			Statement stmt = conn.createStatement();
			
			System.out.println("Statement Created.");
			
			ResultSet rs = stmt.executeQuery(sql);
			try {
				while(rs.next()) {
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					int age = rs.getInt("age");
					int gender = rs.getInt("isMale");
					
					Employee e = null;
					if(gender == 1) {
						e = new Employee(first_name, last_name, age, Employee.Gender.MALE);
					} else {
						e = new Employee(first_name, last_name, age, Employee.Gender.FEMALE);
					}
					
					System.out.println(e);
				}
			} catch (SQLException sqle) {
				System.out.println(sqle);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
}
