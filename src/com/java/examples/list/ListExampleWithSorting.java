package com.java.examples.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.java.examples.hashmap.EmployeeWithSort;

public class ListExampleWithSorting {

	public static void main(String a[]){
		
		EmployeeWithSort emp5 = new EmployeeWithSort(101,"San1",3000);
		EmployeeWithSort emp6 = new EmployeeWithSort(102,"San2",2000);
		EmployeeWithSort emp7 = new EmployeeWithSort(103,"San3",5000);
		EmployeeWithSort emp8 = new EmployeeWithSort(104,"San4",1000);

		List<EmployeeWithSort> empList = new ArrayList<EmployeeWithSort>();
		empList.add(emp5);
		empList.add(emp6);
		empList.add(emp7);
		empList.add(emp8);
		
		System.out.println("Display elements in List without Sorting");
		Iterator iterList = empList.iterator();
		while(iterList.hasNext()) {
			EmployeeWithSort e = (EmployeeWithSort) iterList.next();
			System.out.println(e.getId()+":"+e.getName()+":"+e.getSalary());
		}
		
		//Sorting here using Comparable interface
		Collections.sort(empList);

		System.out.println("Display elements in List with Sorting");
		Iterator iterList2 = empList.iterator();
		while(iterList2.hasNext()) {
			EmployeeWithSort e = (EmployeeWithSort) iterList2.next();
			System.out.println(e.getId()+":"+e.getName()+":"+e.getSalary());
		}
		
	}
	
}
