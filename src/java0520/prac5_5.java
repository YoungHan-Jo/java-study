package java0520;

import java.util.Arrays;

public class prac5_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ballArr = new int[] {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
		for(int i = 0; i < ballArr.length; ++i) {
			int n = (int)(Math.random()*ballArr.length);
			int temp = ballArr[i];
			ballArr[i] = ballArr[n];
			ballArr[n] = temp;
		}
		
		ball3 = Arrays.copyOf(ballArr, 3);
		
		for(int i = 0; i < ball3.length; ++i)
			System.out.print(ball3[i]);
		
		
		
	}// main

}
