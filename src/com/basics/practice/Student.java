package com.basics.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
	int studentId;
	String studentName;
	int studentScore;
	//Map<String,Integer> courseInstMap = new HashMap<String,Integer>();
	Map<Integer, List<Student>> testmap = null;
	
	public Map<Integer, List<Student>> getTestmap() {
		return testmap;
	}

	public void setTestmap(Map<Integer, List<Student>> testmap) {
		this.testmap = testmap;
	}

	public Student(int studentId, String studentName, int studentScore) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
	}
	
	public Student() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}
	
	
}
