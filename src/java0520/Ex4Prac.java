package java0520;

import java.util.Arrays;

public class Ex4Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[4][3];
		
		a[0][0]=10;		a[0][1]=20;		a[0][2]=30;
		a[1][0]=40;		a[1][1]=50;		a[1][2]=60;
		a[2][0]=70;		a[2][1]=80;		a[2][2]=90;
		a[3][0]=100;	a[3][1]=110;	a[3][2]=120;
		
		for(int i = 0 ; i < a.length; ++i) {
			for(int j = 0 ; j < a[0].length ; ++j) {
				System.out.printf("%d\t",a[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("========================");
		
		int[][] b = {{10,20},
				 	{30,40},
				 	{50,60}};
		
		System.out.println("행 개수 : " + b.length);
		System.out.println("열 개수 : " + b[0].length);
		
		for(int r = 0 ; r < b.length; ++r) {
			for(int c = 0; c < b[0].length ; ++c)
				System.out.printf("%d\t",b[r][c]);
			System.out.println();
		}
		
		
		
	} // main

}
