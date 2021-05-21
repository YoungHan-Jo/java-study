package java0520;

public class Ex2 {

	public static void main(String[] args) {
		// 점수 배열
		int[] score = { 100, 90, 80, 70, 67 };
		int sum = 0; // 점수 합
		double avg = 0; // 점수 평균


		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			
		}
		avg = (double) sum / score.length;

		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
	} // main

}
