package java0520;

import java.util.Arrays;

public class Ex3Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numArr = new int[] {79, 88, 91, 33, 100, 55, 95, 81, 75, 64};
		
		int evenCnt = 0;
		int oddCnt = 0;
		int evenSum = 0;
		int oddSum = 0;
		
		for(int i = 0; i < numArr.length ; ++i) {
			if(numArr[i]%2 == 0) {// even
				evenSum += numArr[i];
				evenCnt++;
			}else if(numArr[i]%2 == 1) { //odd
				oddSum += numArr[i];
				oddCnt++;
			}
		}
		
		System.out.println("짝수 개수 : " + evenCnt);
		System.out.println("홀수 개수 : " + oddCnt);
		System.out.println("짝수 합 : " + evenSum);
		System.out.println("홀수 합 : " + oddSum);
		
		System.out.println("=================================");
		
		int max = numArr[0];
		int min = numArr[0];
		
		for(int i = 0; i < numArr.length; ++i) {
			if(max <= numArr[i])
				max = numArr[i];
			if(min >= numArr[i])
				min = numArr[i];
		}
		System.out.println("제일 큰 수 : " + max);
		System.out.println("제일 작은 수 : " + min);
		
		// 내림차순 정렬
		
		for(int i = 0; i < numArr.length; ++i) {
			for(int j = i+1; j < numArr.length; ++j) {
				if(numArr[i] <= numArr[j]) {
					int temp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(numArr));
		
		for(int i = 0; i < numArr.length; ++i) {
			for(int j = i+1; j < numArr.length; ++j) {
				if(numArr[i] >= numArr[j]) {
					int temp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(numArr));
		
	}// main

}
