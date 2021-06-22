package java0622;

import java0622.accesstest.SubAccessTest;

public class Ex3 {

	public static void main(String[] args) {
		
		AccessTest at = new AccessTest();
		at.showData();
		//System.out.println(at.a); // a는 접근안됨
		System.out.println(at.b);
		
		SubAccessTest at2 = new SubAccessTest();
		at2.subShowData();
		
	} // main

}
