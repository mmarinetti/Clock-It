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
			isConnected = true;
			System.out.println("Connected to database: " + databaseURL);
		} catch (ClassNotFoundException e) {
			isConnected = false;
			e.printStackTrace();
		} catch (SQLException e) {
			isConnected = false;
			e.printStackTrace();
		}
		
		return isConnected;
	}
	
	public boolean ClockInEmployee(Employee e) {
		return false;
	}
	
	public boolean ClockOutEmployee(Employee e) {
		return false;
	}
	
	public boolean AddEmployee(Employee e) {
		boolean result = false;
		if(isConnected) {
			String sql = "INSERT INTO Employees VALUES (" + e.getEmployee_id() + ",'" + e.getFirst_name() + "','" +
				e.getLast_name() + "'," + e.getAge() + "," + e.getStart_date() + "," + e.getEnd_date() + ",";
			
			if(e.getGender() == Employee.Gender.MALE)
				sql += "1";
			else
				sql += "0";
			
			sql += ",";
			
			if(e.getWorking())
				sql += "1";
			else
				sql += "0";
			
			sql += ")";
			
			try {
				Statement stmt = conn.createStatement();
				
				System.out.println("INSERT STATEMENT CREATED.");
				
				int r = stmt.executeUpdate(sql);
				
				System.out.println("Updated " + r + " records.");
				result = true;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			
		}
		return result;
	}
	
	public boolean RemoveEmployee(Employee e) {
		boolean result = false;
		if(isConnected) {
			String sql = "DELETE FROM Employees WHERE first_name='" + e.getFirst_name() + "'AND last_name='" + e.getLast_name() + "'";
			
			try {
				Statement stmt = conn.createStatement();
				
				System.out.println(sql);
				
				int r = stmt.executeUpdate(sql);
				
				System.out.println("Updated " + r + " records.");
				result = true;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return result;
	}
	
	public void displayEmployees() {
		if(isConnected) {
			String sql = "SELECT * FROM Employees";
			
			try {
				Statement stmt = conn.createStatement();
				
				System.out.println("SELECT STATEMENT CREATED.");
				
				ResultSet rs = stmt.executeQuery(sql);
				try {
					while(rs.next()) {
						String first_name = rs.getString("first_name");
						String last_name = rs.getString("last_name");
						int age = rs.getInt("age");
						int gender = rs.getInt("isMale");
						int isWorking = rs.getInt("working");
						
						Employee e = null;
						if(gender == 1) {
							e = new Employee(first_name, last_name, age, Employee.Gender.MALE);
						} else {
							e = new Employee(first_name, last_name, age, Employee.Gender.FEMALE);
						}
						
						if(isWorking == 1) {
							e.setWorking(true);
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
	
	public void closeConnection() {
		if(isConnected) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
