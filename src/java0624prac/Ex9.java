package java0624prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Puppy> puppyMap = new HashMap<>();
		
		puppyMap.put("우리집 강아지", new Puppy("푸들",5));
		puppyMap.put("철수집 강아지", new Puppy("포메",4));
		puppyMap.put("영희집 강아지", new Puppy("시바",3));
		
		System.out.println(puppyMap);
		
		puppyMap.put("영희집 강아지", new Puppy("치와와",2));
		
		System.out.println(puppyMap);
		
		System.out.println("======================================");
		
		Puppy puppy = puppyMap.get("영희집 강아지");
		System.out.println(puppy.toString());
		
		System.out.println("===================================");
		
		Set<String> keySet = puppyMap.keySet();
		Iterator<String> iter = keySet.iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			
			Puppy p = puppyMap.get(key);
			
			System.out.println(p.toString());
		}
		
		
		
		
	} // main

}
