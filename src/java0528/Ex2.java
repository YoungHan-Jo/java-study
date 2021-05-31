package java0528;

public class Ex2 {
	static void hello() {
		System.out.println("Hello Java");
	}

	static void sum(int a, int b) {
		if (a < 0 || b < 0)
			return;
		System.out.printf("%d + %d = %d\n", a, b, a + b);
	}

	static int abs(int a) {
		if (a < 0)
			a *= -1;
		return a;
	}

	static int max(int a, int b) {
		return a >= b ? a : b;
	}

	static int oneToNumSum(int a) {
		if (a < 0)
			return -1;
		int sum = 0;
		for (int i = 1; i <= a; i++) {
			sum += i;
		}
		return sum;
	}

	static int randomNum(int fromA, int range) {
		return (int) (Math.random() * range) + fromA;
	}

	static int[] getThreeNum() {
		int[] arr = new int[3];

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = randomNum(1, 10);
		}

		return arr;
	}

	public static void main(String[] args) {
		// hello() 호출 하면 "Hello Java" 출력
		hello();
		// sum(10, 20) 호출 - "10 + 20 = 30" 출력
		sum(10, 20);
		// abs(-5) 호출 - 절대값 구한결과 리턴
		System.out.println(abs(-5));
		// max( 10, 20 ) 호출 - 최대값(20) 만 리턴
		System.out.println(max(10, 20));
		// oneToNumSum(10) 호출 - 1부터 입력한 값 까지 합계를 리턴
		System.out.println(oneToNumSum(10));
		// randomNum(1,10) 호출 - 1~10 사이의 임의의 정수 구해서 리턴
		System.out.println(randomNum(1, 10));

		int[] arr = getThreeNum();
		
		for(int i = 0; i<arr.length;++i)
		{
			System.out.print(arr[i] + " ");
		}
	} // main

} // class
