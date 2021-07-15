package java0715;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex6 {

	public static void main(String[] args) {
		System.out.println("test2.txt 파일을 읽어서 test2-복사본.txt 파일을 생성하는 프로그램.");

		String projectPath = System.getProperty("user.dir"); // 현재 프로젝트 절대경로

		String inputPath = projectPath + "\\temp\\test2.txt";
		String outputPath = projectPath + "\\temp\\test2-복사본.txt";

		// 파일 문자 입력스트림
		BufferedReader reader = null; // finally 에서 닫을 때 쓰려고 미리 선언해두는것.

		// 파일문자 출력스트림
		FileWriter writer = null; // 쓰기는 버퍼가 보통 달려있음.

		try {
			reader = new BufferedReader(new FileReader(inputPath)); // 버퍼 내용물 달아주기

			writer = new FileWriter(outputPath);

			String line = "";

			while ((line = reader.readLine()) != null) {

				writer.write(line + "\n");

				// writer.flush(); // writer.close() 하면 버퍼를 비워서 생략가능, 때에따라 필요할때도 있음
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	}// end of main

}
