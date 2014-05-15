package com.employee;

public class StudentEmployee extends Employee {
	private static final int MAX_HOURS = 25;
	
	private String PID;
	
	public void setHoursWorked(int hoursWorked) {
		if(hoursWorked > MAX_HOURS) {
			this.hoursWorked = MAX_HOURS;
		} else {
			super.setHoursWorked(hoursWorked);
		}
	}

	public String getPID() {
		return PID;
	}

	public void setPID(String pid) {
		if(pid.matches("[A-Z]{1}[0-9]{8}")) {
			this.PID = pid;
		}
	}
	
	public StudentEmployee(String first_name, String last_name, int age, Gender gender, String pid) {
		super(first_name, last_name, age, gender);
		
		this.setPID(pid);
	}
	
	public String toString() {
		return super.toString() + "\tPID: " + this.PID;
	}
}
