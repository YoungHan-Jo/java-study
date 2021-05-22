package java0520;

public class prac3 {

	public static void main(String[] args) {
		// 배열 합 구하기
		
		
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
		}
		
		System.out.println("sum = " + sum);
		

	}

}
