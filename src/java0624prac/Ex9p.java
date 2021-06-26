package java0624prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex9p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Puppy> puppyMap = new HashMap<>();
		
		puppyMap.put("우리집 강아지", new Puppy("푸들",3));
		puppyMap.put("철수네 강아지", new Puppy("시바",2));
		puppyMap.put("영희네 강아지", new Puppy("포메",5));
		
		System.out.println(puppyMap);
		
		System.out.println("==========================");
		
		Set<String> keySet = puppyMap.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Puppy p = puppyMap.get(key);
			System.out.println(key + " : " + p.toString());
		}
		
		
	} //main

}
