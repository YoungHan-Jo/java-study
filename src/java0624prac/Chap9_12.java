package java0624prac;

import java.util.StringJoiner;

public class Chap9_12 {

	public static void main(String[] args) {
		
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");
		String aniJoin = String.join("-", arr);
		System.out.println(aniJoin);
		
		StringJoiner strJoin = new StringJoiner(",", "[", "]"); // 객체 생성 [ ] 모양으로
		
		for(String s : arr) // strJoin 객체에 arr 배열의 리스트 하나씩 추가하기
			strJoin.add(s);
		
		strJoin.add("tiger");
		
		System.out.println(strJoin);
		
		

	} // main

}
