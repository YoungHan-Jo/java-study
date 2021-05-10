package java0510;

public class Ex1 {

	public static void main(String[] args) {
		System.out.println("Hello, world \n");
		System.out.print("3 + 5 = ");
		System.out.println(3 + 5);
		
		System.out.println("==============================");
		
		// 1bit = 이진수 (0 or 1)
		// 1byte = 8bit
		
		
		//변수의 타입
		// 숫자
		//    정수 : int{(4byte):기본값}, long(8byte)
		//	  실수 : float(4byte), double{(8byte):기본값}
		
		// 문자
		//	char(2byte) 문자 한개 저장하는 용도
		//	String 문자열 객체(문자 여러개 나열해서 표현가능)
		// String 은 객체 참조 자료형
		
		int x = 100;
		double pi = 3.14; // (d 생략 가능)
		char ch = 'a';
		String str = "abc";
		
		System.out.println(x);
		System.out.println(pi);
		System.out.println(ch);
		System.out.println(str);
		
		final int MAX_SPEED = 10; 
		//변수의 상수화. final 키워드로 상수 선언.
		// 변수이름을 주로 대문자로 쓰는게 관례
		System.out.println(MAX_SPEED + 1);
		
		int octNum = 010;
		int hexNum = 0x10;
		
		long big = 100_000_000_000L;
		//long형 변수 = long형 리터럴 값 (뒤에L 붙임)
		System.out.println("big = " + big);
		
		float fNum = 3.14f;
		//float형 변수 = float형 리터럴 값 (뒤에 f 붙임)
		System.out.println("fNum = " + fNum);
		
		char chVal = 'J'; // 안에 비어있으면 안됨 , 스페이스라도
		String strVal = ""; // 빈 문자열, 비어도 됨
		
		char chVal2 = 65;
		System.out.println("chVal2 = " + chVal2);
		
	}

}
