package java0514;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// if - else if 예제

		int score = 0;
		char grade = ' ';

		System.out.printf("점수를 입력하세요. >");

		Scanner scanner = new Scanner(System.in);

		score = scanner.nextInt();

		// 학점 판별
		// 90점대 A
		// 80점대 B
		// 70점대 C
		// 70점 미만 D

		// if 문에서 조건식은 위에서부터 한개씩 따지고 나려옴.
		// 참이면 탈출
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else {
			grade = 'D';
		}

		System.out.println("당신의 학점은 " + grade + "입니다.");

	} // main

}
