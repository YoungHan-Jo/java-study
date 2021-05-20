package hw4;

public class prac4 {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 1; i < 300; i++) {
			if (i % 2 == 0) {
				sum -= i;
				continue;
			} else {
				sum += i;
			}
			
			if (sum >= 100) {
				System.out.printf("%d까지 더하면%d\n", i,sum);
				break;
			}
			
		}
		

	} // main

}
