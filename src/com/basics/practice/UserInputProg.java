package com.basics.practice;

import java.util.Scanner;

public class UserInputProg {
	public static void main(String[] x){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter username:");
		String username = scan.nextLine();
		System.out.println("username entered is:"+username);
		
		String username2;
	    double age;
	    String gender;
	    String marital_status;
	    int telephone_number;

	    //Allows a person to enter his/her name   
	    Scanner one = new Scanner(System.in);
	    System.out.println("Enter Name:" );  
	    username2 = one.next();
	    System.out.println("Name accepted " + username2);


	    //Allows a person to enter his/her age   
	    System.out.println("Enter Age:" );  
	    age = one.nextDouble();
	    System.out.println("Age accepted " + age);


	    //Allows a person to enter his/her gender  
	    System.out.println("Enter Gender:" );  
	    gender = one.next();
	    System.out.println("Gender accepted " + gender);


	    //Allows a person to enter his/her    
	    System.out.println("Enter Marital status:" );  
	    marital_status = one.next();
	    System.out.println("Marital status accepted " + marital_status);


	    //Allows a person to enter his/her    
	    System.out.println("Enter Telephone number:" );  
	    telephone_number = one.nextInt();
	    System.out.println("Telephone number accepted " + telephone_number);
		
	}
}


