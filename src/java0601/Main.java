package java0601;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n, m;
		int count = 0;
		
		n = sc.nextInt();
		
		for(int i = 0; i < n; ++i) {
			m = sc.nextInt();
			
			if(m%2 == 0)
				count++;
		}
		
		System.out.println(count);
		
	}// main

}
