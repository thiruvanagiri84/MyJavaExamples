package com.basics;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.basics.CourseInstance;

public class HashMapEx {

	public static void main(String a[]){
		CourseInstance c1 = new CourseInstance();
		c1.setId(1);
		c1.setTitle("First Course");
		c1.setExpDate(new Date());
		
		CourseInstance c2 = new CourseInstance();
		c2.setId(2);
		c2.setTitle("Second Course");
		c2.setExpDate(new Date());
		
		CourseInstance c3 = new CourseInstance();
		c3.setId(3);
		c3.setTitle("Third Course");
		c3.setExpDate(new Date());
		
		HashMap<Integer, CourseInstance> courseMap = new HashMap<Integer, CourseInstance>();
		courseMap.put(c1.getId(), c1);
		courseMap.put(c2.getId(), c2);
		courseMap.put(c3.getId(), c3);
		
		System.out.println("Iterating using Keys");
		Iterator<Integer> courseIter = courseMap.keySet().iterator();
		while(courseIter.hasNext()){
			int courseId = (Integer) courseIter.next(); // Get key from hashmap
			System.out.println(courseId);
			
			CourseInstance cobj = courseMap.get(courseId); // Get value from hashmap
			System.out.println(cobj.getTitle()+ " :: "+cobj.getExpDate());
		}
		
		System.out.println("Iterating using Values");
		Iterator courseIter2 = courseMap.entrySet().iterator();
		while(courseIter2.hasNext()){
			Map.Entry pair = (Map.Entry)courseIter2.next();
			int courseId = (Integer) pair.getKey();
			System.out.println(courseId);
			
			CourseInstance cobj2 = (CourseInstance) pair.getValue();
			System.out.println(cobj2.getTitle() + " :: "+cobj2.getExpDate());
			
			/*CourseInstance cobj = courseMap.get(courseId); // Get value from hashmap
			System.out.println(cobj.getTitle()+ " :: "+cobj.getExpDate());*/
		}
		
	}
	
}
