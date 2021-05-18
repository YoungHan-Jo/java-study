package hw4;

public class prac1 {

	public static void main(String[] args) {
		
		System.out.print("========== 1 ========== >>");
		int x = 15;
		if (x > 10 && x < 20) {
			System.out.println("true");
		}
		
		System.out.print("========== 2 ========== >>");
		// 4-1-2
		char ch = 'x';
		if (ch == 'x' || ch == 'X') {
			System.out.println("true");
		}
		System.out.print("========== 3 ========== >>");
		// 4-1-3
		ch = 'a';
		if (ch != '\t' && ch != ' ') {
			System.out.println("true");
		}

		System.out.print("========== 4 ========== >>");
		// 4-1-4
		ch = '1';
		if (ch >= '0' && ch <= '9') {
			System.out.println("true");
		}
		
		System.out.print("========== 5 ========== >>");
		// 4-1-5
		ch = 'a';
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			System.out.println("true");
		}
		
		System.out.print("========== 6 ========== >>");
		// 4-1-6
		int year = 440;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println("true");
		}
		
		System.out.print("========== 7 ========== >>");
		// 4-1-7
		boolean powerOn = false;
		if(!powerOn) {
			System.out.println("true");
		}

		System.out.print("========== 8 ========== >>");
		// 4-1-8
		String str = "yes";
		if (str.equals("yes")) {
			System.out.println("true");
		}
		
	} //main

}
