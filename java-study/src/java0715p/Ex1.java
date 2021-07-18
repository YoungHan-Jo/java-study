package java0715p;

import java.io.InputStream;

public class Ex1 {

	public static void main(String[] args) {

		System.out.println("데이터 입력을 중지하려면 ctrl z(-1)를 누르세요");
		
		InputStream in = System.in;
		int data = 0;
		
		try {
			data = in.read();
			System.out.println("data = " + (char) data);
			
			data = in.read();
			System.out.println("data = " + (char) data);
			
			data = in.read();
			System.out.println("data = " + (char) data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	}// end of main

}
