package java0622.accesstest;

import java0622.AccessTest;

public class SubAccessTest extends java0622.AccessTest {

	public void subShowData() {
		System.out.println("SubAccessTest subShowData()");
		//System.out.println("a = " + a); // private 
		//System.out.println("b = " + b); // default 
		System.out.println("c = " + c);		// protected 다른패키지더라도 상속받은 자식이면 가능
		System.out.println("d = " + d);		// public 전체 패키지 가능
	}
}
