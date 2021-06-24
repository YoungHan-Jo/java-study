package java0624;

import java.util.HashMap;
import java.util.Map;

public class Ex9 {

	public static void main(String[] args) {
		// Map 컬렉션 : "키, 값" 쌍으로 데이터를 관리하는 자료구조, 데이터 검색할때 월등함.
		
		Map<String, Puppy> puppyMap = new HashMap<>(); // 이거도 <> 생략가능
		
		//Map는 put 로 추가함. 키는 유일한 값이어야함.
		// 키, 값 쌍으로 저장
		puppyMap.put("우리집 강아지", new Puppy("포메라니안",2));
		puppyMap.put("철수네 강아지", new Puppy("푸들",4));
		puppyMap.put("영희네 강아지", new Puppy("시바",3));
		
		System.out.println(puppyMap);
		
		Puppy puppy = puppyMap.get("영희네 강아지");
		System.out.println(puppy.toString());
		
		//같은 키로 다른 값을 저장하면 값 수정으로 동작함.
		puppyMap.put("영희네 강아지", new Puppy("치와와",8));
		
		puppy = puppyMap.get("영희네 강아지");
		System.out.println(puppy.toString());
		
		puppyMap.remove("영희네 강아지");
		
		System.out.println(puppyMap.toString());
		
		puppyMap.clear();
		System.out.println(puppyMap);
		
	} // main

}
