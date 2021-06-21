package java0621p;

import java.util.Arrays;

public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person[] pArr = new Person[4];
		pArr[0] = new Person("김범수",40);
		pArr[1] = new Person("나얼",42);
		pArr[2] = new Person("박효신",39);
		pArr[3] = new Person("이수",41);
		
		for(Person p : pArr) {
			p.showPerson();
		}
		System.out.println("========================");
		
		Person[] pArr2 = new Person[] {
				new Person("홍길동",5),
				new Person("이순신", 10),
				new Person("이몽룡",11)
		};
		
		for(Person p : pArr2) {
			p.showPerson();
		}
		
		System.out.println("=============================");
		

		
	} // main

}
