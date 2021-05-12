package java0512;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// 문자 ch는 숫자('0' ~ '9')이다.

		Scanner scanner = new Scanner(System.in);
		char ch = ' ';
		System.out.print("문자 한개를 입력하세요: ");
		// scanner.nextLine 는 사용자가 입력하고 엔터키를 치면(줄바꿈을하면)
		// 줄바꿈 문자(\n) 이전까지 문자열로 반환해줌
		String input = scanner.nextLine(); // scanner 은 값을 문자열로 가지고옴
		ch = input.charAt(0); // 0번째 문자 출력
		// char형은 정수형에 속함 (자바는 아스키 코드가 확장된 유니코드 사용)

		System.out.println("입력값 : " + ch);

		if (ch >= '0' && ch <= '9') {
			System.out.printf("입력하신 문자는 숫자입니다.");
		}

		if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
			System.out.println("입력하신 문자는 영문자입니다.");
		}
		
		System.out.println("===========================");
		
		

	} // main

}
