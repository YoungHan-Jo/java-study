package java0517;

public class Ex2 {

	public static void main(String[] args) {
		// while문 : 조건식이 참인동안 반복 수행

		for (int i = 1; i <= 10; i++) { // 10회 반복
			System.out.println(i);
		}

		System.out.println("==============================");

		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}

		System.out.println("===================");

		i = 5;

		while (i != 0) {
			i--;
			System.out.println(i + " - I can do it.");
		}

		System.out.println("===============================");

		// 1부터 몇까지 더해야 100을 넘지 않는지 알아내는 예제
		int sum = 0;
		i = 0;

		while (sum <= 100) {
			System.out.printf("%d까지 더하면 %d%n", i, sum);
			i++;
			sum = sum + i;
		}

		System.out.printf("i = %d, sum = %d%n", i, sum);

	} // main

}
