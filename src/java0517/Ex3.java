package java0517;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// do - while문 : 조건식에 관계없이 한번 수행이 보장됨.

		// 숫자 맞추기 게임
		// : 컴퓨터가 생각한 숫자1~100를 맞추는 게임

		int answer = 0, ranNum = 0;

		ranNum = (int) (Math.random() * 100) + 1;

		System.out.println(ranNum);

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("1~100사이의 숫자를 하나 입력하세요");
			answer = scanner.nextInt();

			if (answer > ranNum) {
				System.out.println("=============================");
				System.out.println("더 작은 수로 다시 시도해보세요.");
			} else if (answer < ranNum) {
				System.out.println("=============================");
				System.out.println("더 큰 수로 다시 시도해보세요.");
			} else {
				System.out.println("============================");
				System.out.println("======== 정답입니다 ========");
				System.out.println("============================");
				break;
			}

		} while (answer != ranNum);
		

//		do {
//			
//			
//		}while(조건식);

	} // main

}
