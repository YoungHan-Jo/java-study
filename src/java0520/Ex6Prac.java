package java0520;

import java.util.Arrays;

public class Ex6Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] score = new int[][] { { 85, 60, 70 }, { 85, 95, 80 }, { 75, 80, 100 }, { 80, 75, 95 },
				{ 100, 65, 80 } };

		for (int r = 0; r < score.length; ++r) {
			int sum = 0;
			float avg = 0.0f;
			System.out.printf("%d번 학생 : \t", r + 1);
			for (int c = 0; c < score[r].length; ++c) {
				System.out.printf("%3d\t", score[r][c]);
				sum += score[r][c];
			}
			avg = (float) sum / score[r].length;
			System.out.printf("// 총점 : %d, 평균 : %.2f\n", sum, avg);
		}

		for (int i = 0; i < score.length; ++i)
			System.out.println(Arrays.toString(score[i]));

		System.out.println(Arrays.deepToString(score));
	}// main

}
