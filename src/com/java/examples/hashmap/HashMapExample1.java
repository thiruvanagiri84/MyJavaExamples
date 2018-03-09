package com.java.examples.hashmap;

import java.util.*;

public class HashMapExample1 {

	public static void main(String[] args) {
		
		Map<Integer,String> hmap1 = new HashMap<Integer,String>();
		hmap1.put(105, "san");
		hmap1.put(103, "arun");
		hmap1.put(101, "jonny");
		hmap1.put(102, "giri");

		System.out.println("Iterating Hashmap elements using Iterator");
		Iterator<Integer> iterMap1 = hmap1.keySet().iterator();
		while(iterMap1.hasNext()) {
			int key = iterMap1.next();
			String value = hmap1.get(key);
			System.out.println(key+":"+value);
		}
		
		System.out.println("\nIterating Hashmap elements using Set - using default key sort");
		Set<Map.Entry<Integer, String>> entrySet = hmap1.entrySet();
		for(Map.Entry<Integer, String> entry: entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		LinkedHashMap linkedHp = sortHashMapByValues(hmap1);
		
		System.out.println("\nIterating Linked Hashmap elements after sorting with values");
		Set<Map.Entry<Integer, String>> entries = linkedHp.entrySet();
		for(Map.Entry<Integer, String> entry: entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
	}
	

	//Example to sort hashmap which has <Integer, String>
	public static LinkedHashMap<Integer, String> sortHashMapByValues(
	        Map<Integer, String> passedMap) {
	    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<String> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);

	    LinkedHashMap<Integer, String> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<String> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        String val = valueIt.next();
	        Iterator<Integer> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Integer key = keyIt.next();
	            String comp1 = passedMap.get(key);
	            String comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}

}
