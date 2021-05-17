package java0517;

public class Ex1 {

	public static void main(String[] args) {
		// 중첩 for문

		for (int j = 1; j <= 3; j++) { // 행의 개수 (3행)
			for (int i = 1; i <= 5; i++) { // 열의 개수 (5열)
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("================");

//		*
//		**
//		***
//		****
//		*****

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
//		    *
//		   **
//		  ***
//		 ****
//		*****

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 구구단 2~9단 전체 출력

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%dx%d=%d\t", i, j, i * j);
			}
			System.out.println();
		}

		System.out.println("========================");
		// 구구단 세로 출력
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%dx%d=%d\t", j, i, i * j);
			}
			System.out.println();
		}

	} // main

}
