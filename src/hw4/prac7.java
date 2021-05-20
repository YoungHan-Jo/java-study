package hw4;

public class prac7 {

	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int num = ch - '0';
			sum += ch - '0';
		
		}
		System.out.println("sum = " + sum);

	}// main

}
