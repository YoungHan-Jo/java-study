package java0520;

public class Ex5Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numArr = { { 1, 2 }, { 3, 4 }, { 5, 6, 7 } };

		for (int r = 0; r < numArr.length; ++r) {
			for (int c = 0; c < numArr[r].length; ++c)
				System.out.print(numArr[r][c] + "\t");
			System.out.println();
		}

		System.out.println("========================");

		String[][] name = new String[][] { { "홍길동", "이순신" }, { "유관순" } };
		
		for(int r = 0; r < name.length; ++r) {
			for(int c = 0; c < name[r].length; ++c)
				System.out.print(name[r][c] + "\t");
			System.out.println();
		}

	}// main

}
