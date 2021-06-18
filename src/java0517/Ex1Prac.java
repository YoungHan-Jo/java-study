package java0517;

public class Ex1Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j<5; ++j)
				System.out.print("*");
			System.out.println();
		}
		System.out.println("======================");
		
		for(int i = 0; i <5; ++i) {
			for(int j = 0; j <=i; ++j)
				System.out.print("*");
			System.out.println();
		}
		System.out.println("======================");
		
		for(int i = 0; i <5; ++i) {
			for(int j = 1; j < 5-i; ++j)
				System.out.print(" ");
			for(int j = 0; j <=i;++j)
				System.out.print("*");
			System.out.println();
		}
		System.out.println("===========================");
		
		for(int i = 0; i <5; ++i) {
			for(int j = 1 ; j < 5 -i; ++j )
				System.out.print(" ");
			for(int j = 0; j < 1 + 2*i; ++j)
				System.out.print("*");
			System.out.println();
		}
		System.out.println("==================");
		
		for(int r = 2; r <=9; ++r) {
			for(int c = 1; c<=9; ++c)
				System.out.printf("%dx%d=%d\t",r,c,r*c);
			System.out.println();
		}
		
		System.out.println("=====================");
		for(int r = 1; r <=9;++r) {
			for(int c = 2;c<=9;++c)
				System.out.printf("%dx%d=%d\t",c,r,c*r);
			System.out.println();
		}
		
		
	} // main

}
