package java0715;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex7 {

	public static void main(String[] args) {
		System.out.println("apple.jpg 이미지 파일을 읽어서 apple-복사본.jpg 파일을 생성하는 프로그램.");

		String projectPath = System.getProperty("user.dir"); // 현재 프로젝트 절대경로

		String inputPath = projectPath + "\\temp\\apple.jpg";
		String outputPath = projectPath + "\\temp\\apple-복사본.jpg";

		// 파일 바이트 입력스트림 (FileInputStream)
		BufferedInputStream in = null; // finally 에서 닫을 때 쓰려고 미리 선언해두는것.

		// 파일 바이트 출력스트림 (FileOutputStream)
		FileOutputStream out = null; // 쓰기는 버퍼가 보통 달려있음.

		try {
			in = new BufferedInputStream(new FileInputStream(inputPath)); // 버퍼 내용물 달아주기

			out = new FileOutputStream(outputPath);

			int data = 0;

			while ((data = in.read()) != -1) { // int형식으로 리턴, -1를 표현하기 위해
				out.write(data);
			}

			System.out.println("파일 복사 완료.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	}// end of main

}
