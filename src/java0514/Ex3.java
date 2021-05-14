package java0514;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// switch 조건문
		// break; 자신을 감싸는 가장 가까운 코드블럭을 탈출함
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("현재 월을 입력하세요.>");
		int month = scanner.nextInt();

		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("현재의 계절은 봄입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("현재의 계절은 여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("현재의 계절은 가을입니다.");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("현재의 계절은 겨울입니다.");
			break;
		default: // if문의 else 같은 역할
			System.out.println("1~12사이의 정수를 입력하세요.");
		}

	} // main

}
