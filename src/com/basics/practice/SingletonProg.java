package com.basics.practice;

public class SingletonProg {

	private static SingletonProg singletonObject = null;
	int x = 4;
	
	private SingletonProg(){
	}
	
	public static SingletonProg getMySingletonInstance(){
		if(singletonObject == null){
			singletonObject = new SingletonProg(); // Lazy initialization, creating object only when needed.
			System.out.println("Creating singleton class object");
		}
		return singletonObject;
	}
	
	public void singletonTestMethod() throws RootElementException{
		System.out.println("Inside test method");
		if(true){
			throw new RootElementException("test Exception message");
		}
	}
	
	public int method2(int y){
		System.out.println("in method2");
		return x+y;
	}
}
