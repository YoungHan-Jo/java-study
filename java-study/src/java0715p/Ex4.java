package java0715p;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4 {

	public static void main(String[] args) {
		System.out.println("키보드에서 입력받은 데이터를 test2.txt 파일로 저장하는 프로그램.");

		String projectPath = System.getProperty("user.dir");

		String savePath = projectPath + "\\temp\\test2.txt";

		// 입력스트림 참조변수
		BufferedReader reader = null;
		// 출력스트림 준비
		FileWriter writer = null;

		try {

			reader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));

			writer = new FileWriter(savePath, true);

			String line = "";

			while ((line = reader.readLine()) != null) {

				writer.write(line + "\n");

				writer.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
