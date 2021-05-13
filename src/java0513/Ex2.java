package java0513;

public class Ex2 {

	public static void main(String[] args) {
		// 제어문(조건문, 반복문)
		// 조건문 : if while do-while

		// 코드블럭에서 변수의 수명주기
		{
			int a = 5;
		}
		// 코드블럭 벗어나면 사용불가능
		// int a = 3;
		// a = a + 1;
		// System.out.println("a = "+ a);

		/*
		 * if(조건식) { 조건식이 참일때 실행문;
		 * 
		 * }
		 */

		int score = 80;

		if (score > 60) {
			System.out.println("합격입니다.");
		}

		System.out.println("===========================");

		int num = -7;
		// 조건문을 이용해서 a 변수값이 음수면 양수로 만들기
		if (num < 0) {
			num *= -1;
		}
		System.out.println("절대값: " + num);

		System.out.println("=======================");

		int a = 30;
		int b = 30;
		int max = 0; // 큰값을 저장할 변수

		if (a > b) {
			max = a;
		} else {
			max = b;
		}
		System.out.println("최대값 : " + max);

		System.out.println("========================");

		// 짝수, 홀수
		a = 6;
		if (a % 2 == 0) {
			System.out.printf("%d은/는 짝수%n", a);
		} else {
			System.out.printf("%d은/는 홀수%n", a);
		}

		// 최소값 구하기
		a = 30;
		b = 20;
		int min = 0;

		if (a < b) {
			min = a;
		} else {
			min = b;
		}
		System.out.println("최소값 : " + min);

		System.out.println("========================");

		// a 값의 경우에 따라 양수,0,음수 출력하기

		if (a > 0) {
			System.out.printf("%d 는 양수", a);
		} else if (a == 0) {
			System.out.printf("%d 는 0", a);
		} else {
			System.out.printf("%d 는 음수", a);
		}

	}// main

}
