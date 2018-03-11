package com.basics.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrasyListProg {
	public static void main(String[] x){
		//System.out.println(System.getProperty("java.runtime.version")); // To get system java version
		
		List<Student> studList = new ArrayList<Student>();
		
		//Creating student objects using parameterised constructor
		Student stud1 = new Student(1,"santosh",50);
		Student stud2 = new Student(2,"kumar",60);
		Student stud3 = new Student(3,"Thiruvanagiri",80);
		
		//Creating student objects using default constructor
		Student stud4 = new Student();
		stud4.setStudentId(4);
		stud4.setStudentName("shika");
		stud4.setStudentScore(100);
		
		studList.add(stud1);
		studList.add(stud2);
		studList.add(stud3);
		studList.add(stud4);
		
		//Testing with HashMap - Settings List into HashMap and retrieving again the same List from the HashMap
		Student stud5 = new Student();
		Map<Integer, List<Student>> testmap = new HashMap<Integer, List<Student>>();
		testmap.put(stud1.getStudentId(), studList);
		stud5.setTestmap(testmap);
		
		Map<Integer, List<Student>> newMap = stud5.getTestmap();
		List<Student> newStudList = newMap.get(1); // here 1 is the studentId of stud1 object
		
		studList = newStudList;
		//HashMap test - End
		
		/* This code is used to call non static method
		ArrasyListProg prog = new ArrasyListProg();
		prog.printListValues(studList);*/
		
		//Calling static method from a static method Main
		if(studList != null){
			printListValues(studList);
		}
		
		//Calling a static method of Utility Final class
		if(studList != null){
			UtilityProg.printListValues(studList);
		}
	}
	
	public static void printListValues(List<Student> studentList){
		Iterator<Student> iter = studentList.iterator();
		while(iter.hasNext()){
			Student s = (Student)iter.next();
			System.out.println(s.getStudentId());
			System.out.println(s.getStudentName());
			System.out.println(s.getStudentScore());
		}
	}
}
