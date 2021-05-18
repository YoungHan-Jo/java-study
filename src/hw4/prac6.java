package hw4;

public class prac6 {

	public static void main(String[] args) {
		
		for(int i = 1; i <=6; i++) {
			for(int j = 1; j<= 6; j++) {
				int sum = i + j;
				if(sum == 6) {
					System.out.printf("주사위A : %d + 주사위B : %d\n", i, j);
				}
			}
		}

	} // main

}
