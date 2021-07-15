package java0715;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Ex2 {

	public static void main(String[] args) {

//		int a = 10;
//		int b;
//		int c;
//		System.out.println(c = b = a); // c를 출력함

		System.out.println("데이터 입력을 중지하려면 ctrl z(-1)를 누르세요");
		//바이트스트림 입출력 메소드는 스트림의 끝을 만나면 -1을 리턴해줌.
		
		InputStream in = System.in;
		PrintStream out = System.out;
		
		int data = 0;
		try {

			while ((data = in.read()) != -1) {
				out.write(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("프로그램 종료");
	}// main

}
