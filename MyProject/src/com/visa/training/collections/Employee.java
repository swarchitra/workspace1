package com.visa.training.collections;

import java.util.Map;
//import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Employee {
	private Map<String, String> employeeDetails;
	
	Employee(){
		employeeDetails = new HashMap<String, String>();
		
	}
	void createEmployees() {
		employeeDetails.put("E1234", "Steve Jobs");
		employeeDetails.put("E2345", "Bill Gates");
		employeeDetails.put("E3456", "Larry Ellison");
		employeeDetails.put("E4567", "Jeff Bezos");
		employeeDetails.put("E8765", "Mark Zukerberg");
		employeeDetails.put("E6789", "Larry Page");
	}
	
	void displayEmployees() {
		System.out.println(employeeDetails);
		//Collections.sort(employeeDetails);
		//Iterator i = employeeDetails.get
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.createEmployees();
		e.displayEmployees();
		Scanner scan  = new Scanner(System.in);
		String key;
		key = scan.next();
		System.out.println(e.employeeDetails.get(key));
		key = scan.next();
		System.out.println(e.employeeDetails.get(key));
		
	}
	
	
	
	
	
	
}
