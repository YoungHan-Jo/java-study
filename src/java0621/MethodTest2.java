package java0621;

public class MethodTest2 {
	//정수형 1개 받아서 출력
	void printData(int num) {
		System.out.println(num);
	}
	
	void printData(int a, int b) {
		System.out.printf("%d\t%d\n",a,b);
	}
	
	void printData(int a, int b, int c) {
		System.out.printf("%d\t%d\t%d\n",a,b,c);
	}
	
	// 가변인자(비정형인자) variable arguments
	void printData(int ... nums) {
		// int... -> int[] 일차원 배열객체로 절달받음
		for(int i = 0; i<nums.length;++i)
			System.out.printf("%d\t",nums[i]);
		System.out.println();
	}
	
}
