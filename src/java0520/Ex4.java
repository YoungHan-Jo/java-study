package java0520;

public class Ex4 {

	public static void main(String[] args) {
		// 2차원 배열
		
		int[][] a = new int[4][3];  // [행][열] 4행 3열
		// 배열 객체는 기본값으로 초기화됨
		
		System.out.println("a[0][0] = " + a[0][0]);

		a[0][0]=10;		a[0][1]=20;		a[0][2]=30;
		a[1][0]=40;		a[1][1]=50;		a[1][2]=60;
		a[2][0]=70;		a[2][1]=80;		a[2][2]=90;
		a[3][0]=100;	a[3][1]=110;	a[3][2]=120;
		
		for(int r = 0;r < 4;r++) {
			for(int c = 0; c <3; c++) {
				System.out.print(a[r][c] + "\t");
			}
			System.out.println();
		}
		System.out.println("=============================");
		
		int[][] b = {{10,20},
					 {30,40},
					 {50,60},
					};
		
		System.out.println("행 개수: " + b.length);
		System.out.println("열 개수: " + b[0].length);
		
		for(int r = 0; r < b.length;r++) {
			for(int c = 0; c < b[0].length;c++) {
				System.out.print(b[r][c] + "\t");
			}
			System.out.println();
		}
		
		
	} // main

}
