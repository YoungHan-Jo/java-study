package java0512;

public class Ex4 {

	public static void main(String[] args) {

		// 논리 부정 연산자
		boolean b = true;
		System.out.printf("b = %b%n", b);
		System.out.printf("b = %b%n", !b);
		System.out.printf("b = %b%n", !!b);
		
		int age = 15;
		// 나이가 10대가 아니다.
		// 10 <= age && age <= 19
		// !(10 <= age && age <= 19)
		// && !not 하면 || 가 됨
		System.out.println();
		
	} // main

}
