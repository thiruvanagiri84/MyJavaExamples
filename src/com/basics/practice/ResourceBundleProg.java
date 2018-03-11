package com.basics.practice;

import java.util.StringTokenizer;

public class ResourceBundleProg {
	public static void main(String[] x){
		String fileName = "email", key = "compBundles";
		String value = UtilityProg.propertyReader(fileName, key);
		System.out.println("Value: "+value);
		
		StringTokenizer st = new StringTokenizer(value,",");
		System.out.println("Tokens");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
	}
}
