package com.basics;

public class StringTest {

	public static void main(String a[]){
		String x = new String("san");
		String y = new String("san");
		String i = "kumar";
		String j = "kumar";
		
		
		System.out.println("(x==y): "+x==y);
		System.out.println("x.equals(y): "+x.equals(y));
		System.out.println("i==j: "+i==j);
		System.out.println("i.equals(j): "+i.equals(j));
		
		System.out.println("(x==y)2: "+x.intern()==y.intern());
		System.out.println("i==j 2: "+i.intern()==j.intern());
	}
	
}
