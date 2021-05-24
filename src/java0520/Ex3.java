package java0520;

public class Ex3 {

	public static void main(String[] args) {
		// 정수형 배열 numArr에 임의의 정수 10개

		int[] numArr = { 79, 88, 91, 33, 100, 55, 95, 81, 75, 64 };

		int evenCnt = 0;
		int oddCnt = 0;
		int evenSum = 0;
		int oddSum = 0;

		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] % 2 == 0) {
				evenSum += numArr[i];
				evenCnt++;
			} else {
				oddSum += numArr[i];
				oddCnt++;
			}
		}

		System.out.println("짝수 개수: " + evenCnt);
		System.out.println("홀수 개수: " + oddCnt);
		System.out.println("짝수 합: " + evenSum);
		System.out.println("홀수 합: " + oddSum);

		System.out.println("============================");

		int max = numArr[0]; // 배열 첫번째 요소값으로 일단 초기화

		for (int i = 1; i < numArr.length; i++) {
			if (max < numArr[i]) {
				max = numArr[i];
			}
		}
		System.out.println("제일 큰 수 : " + max);

		int min = numArr[0];
		
		for (int i = 1; i<numArr.length;i++) {
			if (min >numArr[i]) {
				min = numArr[i];
			}
		}
		System.out.println("제일 작은 수 : " + min);
		
		int a = 10;
		int b = 20;
		
		int tmp = a;
		a = b;
		b = tmp;
		
		System.out.println("a = " + a +"\n"+ "b = " + b);
		
		
		
		
	} // main

}
