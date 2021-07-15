package java0715;

import java.io.BufferedReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4 {

	public static void main(String[] args) {
		System.out.println("키보드에서 입력받은 데이터를 test2.txt 파일로 저장하는 프로그램.");

		String projectPath = System.getProperty("user.dir"); // 현재 프로젝트 절대경로

		String path = projectPath + "\\temp\\test2.txt"; // <- \t 로하면 탭으로 인식해서 \\t
		System.out.println(path); // C:\Users\YoungHan-Jo\Desktop\java-study\src\temp\test2.txt

		// 입력 스트림 참조변수 준비
		BufferedReader reader = null;

		// 출력 스트림 준비
		FileWriter writer = null; // 기본적으로 버퍼가 있음

		try {
			// 입력스트림 객체 준비
			reader = new BufferedReader(new InputStreamReader(System.in, "utf-8")); // 한줄로 쓰는 데코레이터 패턴 // 받아올 형식을 설정.
																					// utf-8은 유니코드 형식
			// inputstreadmreader는 단순히 변환만 시켜주는 변환기 역할.
			// 실제로 받아들이는 거는 system.in이 키보드로 입력한 값을 실제로 받아들이는것.

			// 출력스트림 객체 준비
			writer = new FileWriter(path, true); // boolean append 옵션, 뒤에 추가할지말지

			String line = "";

			while ((line = reader.readLine()) != null) {

				System.out.print(line + "\n");
				writer.write(line + "\n");

				writer.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 닫아줘야함
			try {
				reader.close(); // 최종적으로 사용한 입출력객체를 닫으면. 연결된 모든 객체가 자동으로 닫힘.
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료.");
	} // end of main

}
