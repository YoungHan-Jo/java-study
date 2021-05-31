package java0528;

public class Ex3 {

	static void showArray(int[] A) {
		System.out.println("showArray 함수에서 배열요소 출력 : ");
		for(int i = 0; i<A.length;++i) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
		A[1] = 200;
		
		System.out.println("showArray 함수에서 배열요소 수정 후 출력 : ");
		for(int i = 0; i<A.length;++i) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	static void showNum(int num) {

		System.out.printf("showNum()에서 num 출력 : %d\n", num);
		num = 20;
		System.out.printf("showNum()에서 수정된 num 출력 : %d\n", num);
	}

	public static void main(String[] args) {

		int num = 10;

		showNum(num);

		System.out.printf("main()에서 num 출력 : %d\n", num);

		System.out.println("================================");

		int[] arr = { 10, 20, 30 };
		
		showArray(arr);
		
		System.out.println("main 함수에서 배열요소 출력 : ");
		for(int i = 0; i<arr.length;++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		

	}// main

}// class
