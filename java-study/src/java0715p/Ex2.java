package java0715p;

import java.io.InputStream;
import java.io.PrintStream;

public class Ex2 {

	public static void main(String[] args) {
		System.out.println("데이터 입력을 중지하려면 ctrl z(-1)를 누르세요");
		
		InputStream in = System.in;
		PrintStream out = System.out;
		
		int date = 0;
		
		try {
			
			while((date = in.read()) != -1) {
				out.write(date);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	} // end of main

}
