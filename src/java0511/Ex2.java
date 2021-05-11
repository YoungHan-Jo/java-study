package java0511;

public class Ex2 {

	public static void main(String[] args) {
		// 형변환 연산자 = 명시적(수동)형변환, 강제 형변환
		// 서로 호환되는 자료형 끼리는 형변환이 가능함
		// ->호환 : 기본자료형에서는 숫자형(정수형, 실수형)끼리 형변환 가능

		// 실수형은 정수형보다 항상 큰 타입(자료형)이다.
		double dNum = 85.4;
		int score = (int) dNum; // int형 = double형
		System.out.println("score = " + score);
		System.out.println("dNum = " + dNum);

		long bigNum = 200; // long = int형 // long이 더 커서 자동형변환
		bigNum = 3_000_000_000L;
		System.out.println("bigNum = " + bigNum);

		int intNum = (int) bigNum; // int = (int) long형
		System.out.println("intNum = " + intNum);

		// 컴퓨터는 자료형(type)을 일치시켜야 계산이 가능

		// int + int -> int
		int a = 10;
		int b = 20;
		int c = a + b;

		int d = 30;
		long e = 40L;
		long f = d + e; // -> int + long -> long + long -> long

		float g = 1.23f;
		double h = 3.14;
		double i = g + h; // float + double -> double + double -> double

		// 같은 정수형끼리, or 같은 실수형끼리 연산에서는
		// 바이트 크기가 큰 쪽으로 자동 형변환된 후 연산이 이루어진다.

		// 정수형과 실수형 간에 연산 시에는 바이트 크기와 관계없이
		// 실수가 정수보다 항상 크다

		// long형(8byte) + float형(4byte) -> float + float -> float

		long lNum = 100L;
		float fNum = 3.14f;
		float result = lNum + fNum; // 100.0f + 3.14f
		System.out.println("result = " + result);

		// int / int-> int형
		a = 10;
		b = 4;
		System.out.println(a / b);

		// 실수나눗셈으로하려면
		// 연산자 둘중에 한개이상 실수형으로 변환-> 하나만 해도 자동형변환
		System.out.println((float) a / b); // 형변환 연산자 사용가능

		int aNum = 1_000_000;
		int bNum = 2_000_000;
		long cNum = (long) aNum * bNum; // (long) int * int -> long * int -> long * long ->long
		System.out.println("cNum = " + cNum);

	} // main

}
