package java0517;

public class Ex2Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 1;
		while (i <= 10) {
			System.out.println(i++);
		}
		System.out.println("================");
		i = 5;
		while (i != 0) {
			System.out.println(--i + " - I can do it.");
		}
		System.out.println("===================");
		int sum = 0;
		i = 0;
		while (sum <= 100) {
			sum += i;
			System.out.printf("%d까지 더하면 %d\n", i++, sum);

		}

	} // main

}
