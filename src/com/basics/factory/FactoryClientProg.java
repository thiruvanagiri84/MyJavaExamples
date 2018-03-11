package com.basics.factory;

import java.util.Scanner;

public class FactoryClientProg {

	public static void main(String[] args) {
		CourseFactory factory = new CourseFactoryImpl(); 
		
		//Taking the input from user
		Scanner scan = new Scanner(System.in);
		System.out.println("Thomson Or Firm ?");
		String thomsonOrFirm = scan.nextLine();
		System.out.println("You entered is:"+thomsonOrFirm);
		
		if(thomsonOrFirm.equalsIgnoreCase("thomson")){
			factory.getThomsonOrFirmCourses(thomsonOrFirm);
		}else if(thomsonOrFirm.equalsIgnoreCase("firm")){
			factory.getThomsonOrFirmCourses(thomsonOrFirm);
		}
		
	}

}
