package com.basics.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class StringArrayAndListProg {
	public static void main(String[] x){
		String[] strArr = {"one","two","three","four"};
		String match = "three";
		int index = UtilityProg.findIndexOfMatchIgnoreCase(strArr, match);
		System.out.println("String three match found at position: "+(index+1));
		
		//Looping through String Array & finding index of String "four"
		int i = 0;
		int j = -1;
		for(String sa:strArr){
			if(sa.equalsIgnoreCase("four")){
				j = i;
				break;
			}
			i++;
		}
		System.out.println("String four found at position: "+(j+1));
		
		//String Array to List
		List<String> strList = Arrays.asList(strArr);
		//strList.add("five"); //UnsupportedOperationException.Converting String Array to List, List becomes immutable object. We cannot Add or Remove
		Iterator iter = strList.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		//Another way of converting String Array to ArrayList
		List<String> strList2 = new ArrayList<String>();
		Collections.addAll(strList2,strArr); //Collections.addAll(ArrayList,String Array)
		Iterator iter2 = strList2.iterator();
		System.out.println("String Array to ArrayList using Collections.addAll method");
		while(iter2.hasNext()){
			System.out.println(iter2.next());
		}
		
		//List to String Array
		String[] strArr2 = strList2.toArray(new String[strList2.size()]);
		System.out.println("Length of String Array 2: "+strArr2.length);

		//Converting Byte[] to String
		byte[] byteArr = {4,6,3,2};
		String s = UtilityProg.convertToString(byteArr);
		System.out.println(s);
		
	}
}
