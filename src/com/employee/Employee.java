package com.employee;
import java.util.Date;

public class Employee {
	private static final int DEFAULT_AGE = 0;
	private static final String DEFAULT_FIRST = "De";
	private static final String DEFAULT_LAST = "Fault";
	public static enum Gender {MALE, FEMALE}
	
	private int employee_id;
	private String first_name = DEFAULT_FIRST;
	private String last_name = DEFAULT_LAST;
	private int age = DEFAULT_AGE;
	private Date start_date;
	private Date end_date;
	private Gender employeeGender = Gender.MALE;
	private Boolean working = false;
	protected int hoursWorked = 0;
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		if(first_name.matches("[a-zA-Z]*")) {
			this.first_name = first_name;
		}
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		if(last_name.matches("[a-zA-Z]*")) {
			this.last_name = last_name;
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Gender getGender() {
		return this.employeeGender;
	}
	public void setGender(Gender g) {
		this.employeeGender = g;
	}
	public Boolean getWorking() {
		return working;
	}
	public void setWorking(Boolean working) {
		this.working = working;
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		if(hoursWorked < 0) {
			hoursWorked = 0;
		} else {
			this.hoursWorked = hoursWorked;
		}
	}
	/**
	 * Default constructor
	 */
	public Employee() {
		this(DEFAULT_FIRST, DEFAULT_LAST, DEFAULT_AGE, Gender.MALE);
	}
	
	/**
	 * Create employee
	 * @param first_name First name of employee
	 * @param last_name Last name of employee
	 * @param age Age of employee
	 * @param gender Gender of employee
	 */
	public Employee(String first_name, String last_name, int age, Gender gender) {
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setAge(age);
		this.setGender(gender);
	}
	@Override
	public String toString() {
		return this.first_name + " " + this.last_name + "\tAge: " + this.age + "\tWorking: " + this.working;
	}
}
