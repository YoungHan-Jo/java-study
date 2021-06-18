package java0517;

public class Ex4Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 0;
		int sum = 0;

		while (true) {
			if (sum >= 100)
				break;

			++i;
			sum += i;
		}

		System.out.println("i = " + i);
		System.out.println("sum = " + sum);
		
		System.out.println("==============");
		
		for(int j = 1; j < 10; ++j) {
			if( j == 4)
				break;
			System.out.println(j);
		}

	}// main

}
