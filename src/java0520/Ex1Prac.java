package java0520;

import java.util.Arrays;

public class Ex1Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String str;
//		str = new String("안녕");
//
//		System.out.println(str);

//		int[] arr;
//		arr = new int[5];
//
//		System.out.println(arr[2]);
//
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//
//		for (int i = 0; i < arr.length; ++i) {
//			System.out.println(arr[i]);
//		}

//		int[] score = new int[5];
//
//		for (int i = 0; i < score.length; ++i)
//			score[i] = i * 10;
//		
//		for(int i = 0; i < score.length; ++i)
//			System.out.println(score[i]);
//		// 배열선언과 동시에 초기화
//		int[] arrB = { 10, 20, 30 };
//		
//		for(int i = 0; i < arrB.length; ++i)
//			System.out.println(arrB[i]);
//		
//		System.out.println("============================");
//		arrB = new int[] {100,200,300,400,500}; 
//		
//		for(int i = 0; i < arrB.length; ++i)
//			System.out.println(arrB[i]);
//		
//		System.out.println(Arrays.toString(arrB));;

		int[] arr1 = new int[10];
		int[] arr2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] arr3 = new int[10];

		for (int i = 0; i < arr1.length; ++i) {
			arr1[i] = i + 1;
		}

		for (int i = 0; i < arr3.length; ++i) {
			arr3[i] = (int) (Math.random() * 10) + 1;
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));

	}// main

}
