package com.basics.practice;

public class SubProgOverrideEx extends TestProg {
	
	public void method1(){
		System.out.println("In Sub Class Method1");
	}
	
	public SubProgOverrideEx(){
		System.out.println("In Sub Class Constructor");
	}
	
	public static void main(String[] x){
		TestProg t = new SubProgOverrideEx(); //Overriding
		t.method1();
		//SubProgOverrideEx s = new TestProg(); //Compilation error.Cannot convert from TestProg to SubProg
	}
}
