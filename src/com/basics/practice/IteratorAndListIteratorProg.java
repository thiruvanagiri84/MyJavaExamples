package com.basics.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorAndListIteratorProg {
	public static void main(String[] x){
		//Different way of initializing a List
		System.out.println("Different way of initializing a List");
		List<String> newList = Arrays.asList("santosh","kumar","shika","nandhan");
		
		//Ways of Iterating a List. 1.Iterator
		Iterator<String> iter3 = newList.iterator();
		while(iter3.hasNext()){
			System.out.println(iter3.next());
		}
		//Iterating using For loop
		System.out.println("Iterating using For loop");
		for(String list:newList){
			System.out.println(list);
		}
		System.out.println("Iterating using old For loop");
		for(int r=0;r<newList.size();r++){
			System.out.println(newList.get(r));
		}
		System.out.println("Iterating using While loop");
		int y = 0;
		while(y < newList.size()){
			System.out.println(newList.get(y));
			y++;
		}
		
		//Using ListIterator to iterate in both directions of a List
		ListIterator<String> listIter = newList.listIterator();
		System.out.println("Iterating in forward direction");
		while(listIter.hasNext()){
			System.out.println(listIter.next());
		}
		System.out.println("Iterating in backward direction");
		while(listIter.hasPrevious()){
			System.out.println(listIter.previous());
		}
		
		//Adding an element after "Kumar"
		List<String> list2 = new ArrayList<String>();
		list2.add("san");
		list2.add("kumar");
		list2.add("bhu");
		list2.add("veda");
		
		ListIterator<String> listIter2 = list2.listIterator();
		listIter2.next();
		listIter2.next();
		listIter2.add("thiruvanagiri");
		
		System.out.println("Iterating after adding an element using ListIterator");
		ListIterator<String> listIter3 = list2.listIterator();
		while(listIter3.hasNext()){
			System.out.println(listIter3.next());
		}
		
		//Removing an element "san"
		ListIterator<String> listIter4 = list2.listIterator();
		listIter4.next();
		listIter4.remove();
		
		System.out.println("Iterating after removing an element using ListIterator");
		ListIterator<String> listIter5 = list2.listIterator();
		while(listIter5.hasNext()){
			System.out.println(listIter5.next());
		}
	}
}
