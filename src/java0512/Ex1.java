package java0512;

public class Ex1 {

	public static void main(String[] args) {
		// 소수점 첫째자리에서 반올림(round)
		long result = Math.round(4.52);
		System.out.println("result = " + result);
		System.out.println("==========================");
		// 실수값에서 원하는 자릿수에서 반올림하기
		double pi = 3.141592;
		// 소수점 이하 넷째자리에서 반올림하여 셋째자리까지만 구하기
		// round는 첫째자리 반올림이기 때문에
		// 첫째자리로 만들고 3141.592 / 1000 다시 나눈다
		// 라운드 값은 정수 라서 3142 / 1000.0 double로 나눔
		double shortPi = Math.round(pi * 1000) / 1000.0;
		System.out.println("shortPi = " + shortPi);
		System.out.println("========================");
		// 나머지 연산
		int x = 10, y = 8;

		System.out.printf("%d을 %d로 나누면, %n", x, y);
		System.out.printf("몫은 %d이고, 나머지는 %d입니다.%n", x / y, x % y);

		// 나머지 연산자의 용도는
		// - 어떤 수의 배수 구하기 2의배수 n%2 = 0
		// - 짝수 n%2=0 , 홀수 n%2=1 판별하기

		System.out.println("=========================");
		// 비교연산자
		int a = 10;
		int b = 8;

		boolean bVal = (a == b);
		System.out.println("bVal = " + bVal);
		
		
		
		
		
		

	} // main

}
