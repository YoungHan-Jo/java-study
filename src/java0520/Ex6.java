package java0520;

public class Ex6 {

	public static void main(String[] args) {
		// 정수형 2차원 배열 scores
		// 출력형식
				// 1번 학생 85 60 70 총점 xx 평균 xx
				// 2번 학생 똑같이
		int[][] scores = { { 85, 60, 70 }, { 85, 95, 80 }, { 75, 80, 100 }, { 80, 75, 95 }, { 100, 65, 80 }};
		
		
		for (int r = 0; r < scores.length; r++) {
			int sum = 0;
			float avg = 0.0f;
			
			System.out.printf("%d번 학생\t", r+1);
			for (int c = 0; c < scores[r].length; c++) {
				
				System.out.printf("%3d\t",scores[r][c]);
				sum += scores[r][c];
				avg = (float) sum / scores[r].length;
			}
			System.out.printf("총점 : %d, 평균 : %.2f", sum, avg);
			System.out.println();
		}

	} // main

}
