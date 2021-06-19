package java0528;

import java.util.Arrays;

public class Ex3prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30};
		
		showArray(arr);
		
		System.out.println("메인 함수에서 출력");
		System.out.println(Arrays.toString(arr));
		
	} // main

	static void showArray(int[] a) {
		System.out.println("showArray 함수에서 배열요소 출력 : ");
		System.out.println(Arrays.toString(a));
		a[2] = 300;
		System.out.println("showArray 함수에서 배열요소 수정 후 출력 : ");
		System.out.println(Arrays.toString(a));
	}
	
} // class
