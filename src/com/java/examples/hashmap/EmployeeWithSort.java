package com.java.examples.hashmap;

public class EmployeeWithSort implements Comparable<EmployeeWithSort> {

	private int id;
	private String name;
	private double salary;
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeeWithSort() {
		
	}
	
	public EmployeeWithSort(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	public String displayEmployee() {
		return "Employee [id=" + id + ", name=" + name + ",Salary=" + salary + "]";
	}

	@Override
	public int compareTo(EmployeeWithSort emp2) {
		if(this.salary > emp2.getSalary()) {
			return 1;
		}else if(this.salary < emp2.getSalary()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
