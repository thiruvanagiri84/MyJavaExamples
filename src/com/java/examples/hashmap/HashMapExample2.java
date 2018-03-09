package com.java.examples.hashmap;

import java.util.*;

public class HashMapExample2 {

	public static void main(String a[]) {
		
		Employee emp1 = new Employee(101,"San1",3000);
		Employee emp2 = new Employee(102,"San2",2000);
		Employee emp3 = new Employee(103,"San3",5000);
		Employee emp4 = new Employee(104,"San4",1000);
		
		Map<Integer,Employee> hmap2 = new HashMap<Integer,Employee>();
		hmap2.put(emp2.getId(), emp2);
		hmap2.put(emp1.getId(), emp1);
		hmap2.put(emp4.getId(), emp4);
		hmap2.put(emp3.getId(), emp3);
		
		System.out.println("Display hashmap elements without sorting");
		Set<Map.Entry<Integer, Employee>> entries = hmap2.entrySet();
		for(Map.Entry<Integer, Employee> entry:entries){
			System.out.println("Entry:"+entry);
			Employee emp = entry.getValue();
			System.out.println(emp.getId()+":"+emp.getName()+":"+emp.getSalary());
		}
		
		//Yet to practice - Sorting hashmap using Comparator
		
	}
	
}
